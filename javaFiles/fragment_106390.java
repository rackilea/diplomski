class A {
    private int x;
    public void setX(int x_){x=x_;}
    public int getX(){return x;}
}

class B {
    int y;
    A a;
    public void setY() {
        //Accessing x of A, assume I already have object of A
        if(a.getX() < 0) {
             y = a.getX();
        }
    }
}

class C {
    int y;
    A a;
    public void setY() {
        //Accessing x of A, assume I already have object of A
        int tmpX = a.getX();
        if(tmpX < 0) {
             y = tmpX;
        }
    }
}