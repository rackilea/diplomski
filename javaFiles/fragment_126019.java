User s = new User("CHORT") {
    @Override
    public void sayHello() {
        sayHello2();
    }
    private void sayHello2() {
        System.out.println("HELLO FROM ANONYMOUS CLASS");
    }
};