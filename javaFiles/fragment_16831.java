Class<?> controllerType = Class.forName("some.package"+controllers.getString(i));
MethodHandles.Lookup lookup=MethodHandles.lookup();
Method[] methods = controllerType.getMethods();
Object instance = null;
for (Method m : methods) {
    Route annotation = m.getAnnotation(Route.class);
    if (annotation != null) {
        if(instance == null) instance = controllerType.newInstance();
        Handler<RoutingContext> handler
            =createHandler(lookup, instance, m, RoutingContext.class);
        router.get(annotation.path()).handler(handler);
    }
}