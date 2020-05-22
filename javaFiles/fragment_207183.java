interface MyInterface {
    interface Test {
    }
}

class Test extends MyInterface {
    Test test = new Test(); // thinks this is the MyInterface.Test
}