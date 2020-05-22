class ClonableClass implements Clonable {

....

 protected Object clone() throws CloneNotSupportedException {
//Code to clone
}
}

class Test {

public testClone(){
    ClonableClass  obj = new ClonableClass (); //Main object
    ClonableClass  cloneObject = (ClonableClass)obj .clone(); //Your clone object
}
}