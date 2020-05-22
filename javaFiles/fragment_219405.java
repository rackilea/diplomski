class Test{

    public Service<String> getStringService() {
        // it is a bit strange that we can't explicitely construct a
        // parametrized type from raw type and parameters, so here
        // we use this workaround. This may need a dummy method or
        // variable if this method should have another return type.
        ParametrizedType stringServiceType =
            (ParametrizedType)Test.class.getMethod("getStringService").getGenericReturnType();

        ServiceLoader<Service<?>> loader = ServiceLoader.load(Service<?>.class);
        for(Service<?> service : loader) {
           if(isImplementing(service.getClass(), stringServiceType)) {
              @SuppressWarnings("unchecked")
              Service<String> s = (Service)service;
              return s;
           }
        }
    }

    public boolean isImplementing(Class<?> candidate, ParametrizedType t) {
        for(Type iFace : candidate.getGenericInterfaces()) {
           if(iFace.equals(t)) {
              return true;
           }
           if(iFace instanceof ParametrizedType &&
              ((ParametrizedType)iFace).getRawType().equals(t.getRawType())) {
              return false;
           }
        }
        return false;
    }

}