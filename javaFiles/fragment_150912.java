interface Shape {

    void draw();

    void delete();

    void rotate();
}

abstract class BaseShape implements Shape {

    @Override
    public void draw() {
        //do generic stuff
        //call specific method
        specificDrawStuff();
        //do more generic stuff
    }

    abstract void specificDrawStuff();

    @Override
    public void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class Square extends BaseShape {

    @Override
    void specificDrawStuff() {
        //specfic stuff here
    }
}