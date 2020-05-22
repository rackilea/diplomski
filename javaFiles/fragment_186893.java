public static Test suite() { 
      TestSuite suite = new TestSuite("Sample Tests");

      suite.addTest(new SampleTest("testmethod3"));
      suite.addTest(new SampleTest("testmethod5"));

      return suite; 
 }