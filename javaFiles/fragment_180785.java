interface MyInterface {
    void build(Thingy t);
}

class MyImplOneOfAnInterface implements MyInterface {
    void build(Thingy t) { t.build(this); }
}

...

void buildIt(MyInterface item) {
    item.build(this);
}