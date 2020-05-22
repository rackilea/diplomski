public  class Child extends UnChangeableBaseClass
        implements
            Cloneable {

    int index = 0;

    public Child(int index) {

        this.index = 10;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}