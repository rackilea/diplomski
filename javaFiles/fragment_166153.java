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
        MyClip clone = new MyClip(); // create a new instance of your class
        clone.set(this.dummy);       // make sure it has the same value for 'dummy'
                                     // I would suggest improvement on your setter and getter name, though
        return clone;  // This returns an instance of MyClip, which has the exact same
                       // state as your current, but is a clone, and not the same instance.
    }

}