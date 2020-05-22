FacesContext facesContext = FacesContext.getCurrentInstance();
    if (facesContext == null) {
        FacesContextFactory contextFactory =
            (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        LifecycleFactory lifecycleFactory =
            (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        Lifecycle lifecycle =
            lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        facesContext =
                contextFactory.getFacesContext(request.getSession().getServletContext(),
                                               request, response,
                                               lifecycle);
        // Below is an Inner Class which extends FacesContext to use its below protected method
        AbstractInnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
    }