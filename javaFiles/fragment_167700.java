// Create bean: sampleService2
SampleService2 sampleService2 = new SampleService2();

// Create bean: sampleController2
SampleController2 sampleController2 = new SampleController2();
sampleController2.sampleservice2 = sampleService2; // because @Autowired

// Create bean: sampleController3
SampleController3 sampleController3 = new SampleController3();
sampleController3.sampleservice2 = sampleService2; // because @Autowired