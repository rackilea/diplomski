public enum MySingleton() {
    INSTANCE;

    private int element = 10;

    public void setElement(int element) { this.element = element; }
    public int getElement() { return element; }
}

MySingleton.INSTANCE.setElement(20);
System.out.prinln(MySingleton.INSTANCE.getElement()); // prints 20.