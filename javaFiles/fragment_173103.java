public static void main(String args[]) {
    Box.PrivateObject obj = new Box.PrivateObject();
    Box b = new Box();
    b.setPrivateObject(obj);
    obj.increment(); // not visible     
}