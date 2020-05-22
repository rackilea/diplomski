@Async
@Transactional(propagation = Propagation.REQUIRED)
public void onEvent(String moduleName, String instanceName){

    AuEvent auEvent = new AuEvent();
    auEventDao.persist(auEvent);

    AuModule auModule = auModuleDao.findModule(moduleName, instanceName);
    if (auModule == null) {
        auModule = new AuModule();
        auModule.setInstance(instanceName);
        auModule.setName(moduleName);
    }
    auEvent.setAuModule(auModule);
    // optioanlly you can call here - auEventDao.merge(auEvent); 
}