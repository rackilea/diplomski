private interface Example{
    void doSomething();
}
private Example Inner3 = new Example(){
    private int privateInner3 = 2;
    public void doSomething(){
        System.out.println(privateInner3);
    }
}