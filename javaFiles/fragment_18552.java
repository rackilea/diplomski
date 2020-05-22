private Map<Class<? extends Entity>,
    Class<? extends ActivityService>> serviceMap =
        new ConcurrentHashMap<Class<? extends Entity>,
                              Class<? extends ActivityService>>();
private ApplicationContext context;
private ActivityService getServiceForEntity(Entity e){
    Class<? extends Entity> entityClass = e.getClass();
    Class<? extends ActivityService> serviceClass =
        serviceMap.get(entityClass);
    if(serviceClass==null){
        for(Map.Entry<Class<? extends Entity>,
                      Class<? extends ActivityService>> entry :
            serviceMap.entrySet()){
            if(entry.getKey().isAssignableFrom(entityClass)){
                serviceClass = entry.getValue();
                break;
            }
        }
        if(serviceClass==null){
            // throw a suitable exception
        }
        serviceMap.put(entityClass, serviceClass);
    }
    return context.getBean(serviceClass);
}