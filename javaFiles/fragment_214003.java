@FunctionalInterface <------- COMPILATION ERROR : Invalid '@FunctionalInterface' annotation; I1 is not a functional interface
interface I1 {
    void show1();
    void show2();
}

@FunctionalInterface
interface I2 {
    void show3();
}