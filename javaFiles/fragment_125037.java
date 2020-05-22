private Multimap<String, String> getEndpoints(Environment environment)
{
    Multimap<String, String> resources = ArrayListMultimap.create();
    ResourceConfig jrConfig = environment.jersey().getResourceConfig();
    Set<Object> dwSingletons = jrConfig.getSingletons();

    for (Object singletons : dwSingletons) {        

        if (singletons.getClass().isAnnotationPresent(Path.class)) {                
            AbstractResource resource = IntrospectionModeller.createResource(singletons.getClass());
            AbstractResource superResource = IntrospectionModeller.createResource(singletons.getClass().getSuperclass());

            String uriPrefix = getStringWithoutStartingSlash(resource.getPath().getValue());

            for (AbstractResourceMethod srm :resource.getResourceMethods())
            {
                String uri = uriPrefix;
                resources.put(uri,srm.getHttpMethod());
                LOG.info("Found http method " +srm.getHttpMethod() + " for the path " + uri + " returning (class) " + srm.getReturnType().getName());
            }


            for (AbstractSubResourceMethod srm :resource.getSubResourceMethods())
            {           
                //extended resources methods will be added by hand
                if(superResource != null){
                    for (AbstractSubResourceMethod superSrm : superResource.getSubResourceMethods())
                    {
                        String srmPath = getStringWithoutStartingSlash(srm.getPath().getValue());
                        String superSrmPath = getStringWithoutStartingSlash(superSrm.getPath().getValue());                     

                        Class<?> srmClass = srm.getDeclaringResource().getResourceClass();
                        Class<?> superSrmClass = superSrm.getDeclaringResource().getResourceClass();

                        //add superclass method if methodName is not equal superMethodName
                        if(srmClass.getSuperclass().equals(superSrmClass) && !srm.getMethod().getName().equals(superSrm.getMethod().getName())){
                            String uri = uriPrefix + "/" + srmPath  + "/" + superSrmPath ;                              
                            resources.put(uri,superSrm.getHttpMethod());
                            LOG.info("Found http method " +superSrm.getHttpMethod() + " for the path " + uri + " returning (class) " + superSrm.getReturnType().getName());
                        }   
                    }
                }

                String uri = uriPrefix + "/" + getStringWithoutStartingSlash(srm.getPath().getValue());
                resources.put(uri,srm.getHttpMethod());
                LOG.info("Found http method " +srm.getHttpMethod() + " for the path " + uri + " returning (class) " + srm.getReturnType().getName());           
            }               
        }
    }        
    return resources;
    }