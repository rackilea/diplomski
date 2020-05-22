@Async
@Transactional(propagation = Propagation.REQUIRED)
public void onEvent(String moduleName, String instanceName){
        AuModule auModule = auModuleDao.findModule(moduleName, instanceName);
        if (auModule == null) {
            auModule = new AuModule();
            auModule.setInstance(instanceName);
            auModule.setName(moduleName);
        }
       AuEvent auEvent = new AuEvent();
       auEventDao.persist(auEvent); 

       auEvent.setAuModule(auModule);
       auEventDao.merge(auEvent);
}