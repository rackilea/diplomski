BeanManager beanManager = ...; // get hold of bean manager, can be injected
        CreationalContext<Object> ctx = beanManager.createCreationalContext(null);
        @SuppressWarnings("unchecked")
        InjectionTarget<MyImplementation> injectionTarget = (InjectionTarget<MyImplementation>) beanManager
            .getInjectionTargetFactory(beanManager.createAnnotatedType(myImplementationInstance.getClass())).createInjectionTarget(null);
        injectionTarget.inject(myImplementationInstance, ctx);