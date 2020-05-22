// Do once
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(realObject.getClass());
enhancer.setCallbackType(Airport.class);
Class classForProxy = enhancer.createClass();

// Do for each instance
Enhancer.registerCallbacks(classForProxy, new Callback[]{new EntityInterceptor<>(airport, airportMapper});
Object createdProxy = classForProxy.newInstance();