private Test() {
    this.id = atomicIdGenerator.getAndIncrement();
    // Some lengthy operation to fully initialize this object
}

public static Test createTest() {
    Test test = new Test();
    // this put to a synchronized map forces a happens-before of Test constructor
    testsById.put(test.id, test);
    return test;
}