interface Outer {

    void ofoo();

    interface Inner {

        void ifoo();
    }
}

class MyInfClass implements Outer, Outer.Inner {

    int x;

    @Override
    public void ofoo() {
        //
    }

    @Override
    public void ifoo() {
        //
    }
}

public void test() {
   MyInfClass mic = new MyInfClass();
   Outer obj = mic;
   Outer.Inner iObj = mic;
}