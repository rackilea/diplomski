JavaSampler javaSampler = new JavaSampler();
javaSampler.setName("Java Request");
javaSampler.setClassname("org.apache.jmeter.protocol.java.test.SleepTest");
Arguments arguments = new Arguments();
arguments.addArgument("SleepTime", "1000");
arguments.addArgument("SleepMask", "0x33F");
javaSampler.setArguments(arguments);
javaSampler.setProperty(TestElement.TEST_CLASS, JavaSampler.class.getName());
javaSampler.setProperty(TestElement.GUI_CLASS, JavaTestSamplerGui.class.getName());