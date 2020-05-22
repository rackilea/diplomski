public class JMeterTestFromCode {

    public static void main(String[] args) throws Exception{

         String jmeterHome1 = "/rezsystem/apache-jmeter-2.11/apache-jmeter-2.11";
         File jmeterHome=new File(jmeterHome1);
         String slash = System.getProperty("file.separator");

         if (jmeterHome.exists()) {
             File jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
             if (jmeterProperties.exists()) {
                 //JMeter Engine
                 StandardJMeterEngine jmeter = new StandardJMeterEngine();

                 //JMeter initialization (properties, log levels, locale, etc)
                 JMeterUtils.setJMeterHome(jmeterHome.getPath());
                 JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
                 JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
                 JMeterUtils.initLocale();

                 // JMeter Test Plan, basically JOrphan HashTree
                 HashTree testPlanTree = new HashTree();     

                 // HTTP Sampler
                 HTTPSampler httpSampler = new HTTPSampler();
                 httpSampler.setDomain("www.google.com");
                 httpSampler.setPort(80);
                 httpSampler.setPath("/");
                 httpSampler.setMethod("GET");

                 // Loop Controller
                 TestElement loopCtrl = new LoopController();
                 ((LoopController)loopCtrl).setLoops(1);
                 ((LoopController)loopCtrl).addTestElement(httpSampler);
                 ((LoopController)loopCtrl).setFirst(true);

                 // Thread Group
                 SetupThreadGroup threadGroup = new SetupThreadGroup();
                 threadGroup.setNumThreads(1);
                 threadGroup.setRampUp(1);
                 threadGroup.setSamplerController((LoopController)loopCtrl);

                 // Test plan
                 TestPlan testPlan = new TestPlan("MY TEST PLAN");

                 testPlanTree.add("testPlan", testPlan);
                 testPlanTree.add("loopCtrl", loopCtrl);
                 testPlanTree.add("threadGroup", threadGroup);
                 testPlanTree.add("httpSampler", httpSampler);     

                 JmeterOutListener jmeterOutListener = new JmeterOutListener();
                 testPlanTree.add(testPlanTree.getArray()[0], jmeterOutListener);

                 // Run Test Plan
                 jmeter.configure(testPlanTree);
                 jmeter.run();

                 System.exit(0);

             }
         }

         System.err.println("jmeter.home property is not set or pointing to incorrect location");
         System.exit(1);    

    }
}