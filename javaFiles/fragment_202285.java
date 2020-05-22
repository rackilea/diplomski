boolean existsObject = false;
ObjectName objName = new ObjectName("amx:pp=/domain/resources,type=custom-resource,name=test/TestCR");
try {
    MBeanServer mbean = ManagementFactory.getPlatformMBeanServer();
    existsObject = mbean.getObjectInstance(objName) != null;
    if (existsObject) {
       Object attr = mbean.getAttribute("amx:pp=/domain/resources/custom-resource[test/TestCR],type=property,name=version", "Value");
       // here 'attr' var is indicating '1', as I've set! (I tested with other values too) 
    }
} catch (Throwable e) {
    existsObject = false;
}