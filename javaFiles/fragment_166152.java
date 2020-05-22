class MyClip implements Cloneable {

    Clip dummy;

    public MyClip() {

    }

    public Clip get() {
        return dummy;
    }

    public void set(Clip c) {
        this.dummy = c;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }    
}