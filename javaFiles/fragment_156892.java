public abstract class Company<T extends Cat> {
    public Box<T> getFavBox() {
        // ...
    }
    public Set<Box<T>> getBoxes() {
        // ...
    }
}

Company<? extends Cat> o = new ETCatCompany();
Box<? extends Cat> boxes = o.getFavBox();        // ok
Set<Box<? extends Cat>> boxes = o.getBoxes();    // error