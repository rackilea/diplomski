Thread.currentThread().sleep(20000);
Map<String, Object> input1 = new HashMap<String, Object>();
input1.put("input", new Dto());
KieServices ks1 = KieServices.Factory.get();
KieFileSystem kfs1 = ks1.newKieFileSystem();

kfs1.write(ResourceFactory.newFileResource(new File(
        "C:/Users/workspace1/Drools_POC/src/poc.drl")));
ks1.newKieBuilder(kfs1).buildAll();
KieContainer kieContainer1 = ks.newKieContainer(ks.getRepository()
        .getDefaultReleaseId());

KieSession kieSession1 = kieContainer1.newKieSession();
kieSession1.insert(input1);
System.out.println("Fired all rules 1");

kieSession1.fireAllRules();
System.out.println(((Dto) input1.get("input")).getName());