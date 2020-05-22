@Test(dataProvider = "HexgenControllersData")
    public void hexgenControllersTest(KnownGoodInfo knownGoodInfoRO, Object[] methodInfoObject) throws Exception {
        int httpResponseStatus=0;
        String requestURL = "";

        HttpClient authenticationObject = null;
        MethodProperties methodPropertiesRO = null;
        HttpRequestHandler httpRequestHandler = new HttpRequestHandler();

        methodPropertiesRO = (MethodProperties) methodInfoObject[0];
        //Attempts to login to hexgen application
        authenticationObject = httpRequestHandler.loginToHexgen(knownGoodInfoRO.getUser(), knownGoodInfoRO.getPassword());
        requestURL = HexgenControllersTestConstants.DEFAULT_URL + methodPropertiesRO.getUrl();
        //Attempts to send url request and gets the http response code
        httpResponseStatus = httpRequestHandler.handleHTTPRequest(authenticationObject, requestURL,methodPropertiesRO.getRequestingMethod(),(List) methodInfoObject[1]);
        Assert.assertEquals(knownGoodInfoRO.getHttpResponse(), httpResponseStatus);
    }
    @DataProvider(name = "HexgenControllersData")
    public static Object[][] dataProviderForSecurityinference() {
        String[] requestMappingValues = null;
        String[] parametersDefinedForMethod = null;
        String strClassname = "";
        String strClassNameToFix = "";
        String requestingMethod = "";

        List<MethodParamsInfo> tempParamsList = null;
        List<String> notSecuredMethodsList = null;
        Map<String, List> methodParametersMap = new LinkedHashMap<String, List>();
        Map<String, MethodProperties> methodPropertiesMap = new LinkedHashMap<String, MethodProperties>();
        Map<String, KnownGoodInfo> knownGoodMap = null;

        MethodParamsInfo methodParams = null;
        MethodProperties methodPropertiesRO = null;
        DataProviderForHexgenControllers dataProviderForHexgenControllers = null;

        try {
            dataProviderForHexgenControllers = new DataProviderForHexgenControllers();
            Class classInstance;
            List controllerClassNames = dataProviderForHexgenControllers.findControllerClasses(HexgenControllersTestConstants.BASE_PACKAGE);
            Iterator<Class> classNames = controllerClassNames.iterator();
            notSecuredMethodsList = new ArrayList<String>();
            while (classNames.hasNext()) {
                Class className = classNames.next();
                classInstance = Class.forName(className.getName());
                Method[] methods = classInstance.getDeclaredMethods();

                for (Method method : methods) {
                    // gets the method which is maped with RequestMapping Annotation
                    RequestMapping requestMappingAnnotation = method.getAnnotation(RequestMapping.class);

                    // requestMappingAnnotation if condition Starts
                    if (requestMappingAnnotation != null) {
                        PreAuthorize preAuthorizeAnnotation = method.getAnnotation(PreAuthorize.class);  
                        // record the method name if it is not annotated with preAuthorize
                        if (preAuthorizeAnnotation == null) {
                            notSecuredMethodsList.add("Class : "+className.getName() + "  Method : " + method.getName());
                        }

                        // to get the url value
                        requestMappingValues = requestMappingAnnotation.value();

                        // to get the request method type
                        RequestMethod[] requestMethodWithURL = requestMappingAnnotation .method();

                        requestingMethod = requestMethodWithURL[0].name();

                        // Attempts to get the request url and the requesting method type
                        methodPropertiesRO = new MethodProperties();
                        methodPropertiesRO.setRequestingMethod(requestingMethod);
                        methodPropertiesRO.setUrl(requestMappingValues[0]);
                        methodPropertiesMap.put(method.getName(),methodPropertiesRO);

                        Class[] parameterTypes = method.getParameterTypes();
                        LocalVariableTableParameterNameDiscoverer localVariableDefinedDiscover = new LocalVariableTableParameterNameDiscoverer();
                        parametersDefinedForMethod = localVariableDefinedDiscover
                                .getParameterNames(method);

                        tempParamsList = new ArrayList();
                        // check the parameter type and put them in to a
                        // ArrayList
                        for (int i = 0; i < parameterTypes.length; i++) {
                            methodParams = new MethodParamsInfo();
                            Class parameterType = parameterTypes[i];
                            strClassNameToFix = parameterType.getName();
                            strClassname = strClassNameToFix .replaceAll( HexgenControllersTestConstants.PATTERN_TO_REMOVE,HexgenControllersTestConstants.PATTERN_TO_REPLACE)
                                           .replaceAll( HexgenControllersTestConstants.PATTERN_TO_REMOVE_SEMICOLON, HexgenControllersTestConstants.PATTERN_TO_REPLACE);

                            methodParams.setDataType(strClassname);
                            methodParams.setVariableDefined(parametersDefinedForMethod[i]);

                            if (parameterType.isArray()) {
                                methodParams.setArray(true);
                            }
                            if (parameterType.isPrimitive()) {
                                methodParams.setPrimitive(true);
                            }
                            // FIXME find some better way to address this problem
                            if (strClassname .equals(HexgenControllersTestConstants.BIGDECIMAL)
                                    || strClassname .equals(HexgenControllersTestConstants.STRING)
                                    || strClassname .equals(HexgenControllersTestConstants.BOOLEAN)) 
                                {
                                    methodParams.setPrimitive(true);
                                }
                            tempParamsList.add(methodParams);
                        }
                        methodParametersMap.put(method.getName(),tempParamsList);

                    }// requestMappingAnnotation if condition Ends

                }
            }
            dataProviderForHexgenControllers = new DataProviderForHexgenControllers();
            knownGoodMap = new LinkedHashMap<String, KnownGoodInfo>();
            knownGoodMap =  dataProviderForHexgenControllers.getKnownGoodMap(HexgenControllersTestConstants.KNOWN_GOOD_FILE_PATH);
        } catch (Exception dataProviderForSecurityinferenceException) {
            dataProviderForSecurityinferenceException.printStackTrace();
        }

        List<Object[]> hexgenSecurityInferenceData = new ArrayList<Object[]>();
        for (String methodName:knownGoodMap.keySet()) {
            hexgenSecurityInferenceData.add(new Object[] {
                    knownGoodMap.get(methodName),
                new Object[] {
                    methodPropertiesMap.get(methodName),
                    methodParametersMap.get(methodName)
                }
             });
         }
        Object[][] securityInferenceData = hexgenSecurityInferenceData.toArray(new Object[0][]);
        return  securityInferenceData;
    }