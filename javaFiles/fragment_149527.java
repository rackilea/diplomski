public class Element<T> {
    T otherElement;   

    public void setOther(T element) {
        this.otherElement = element;
    }
}

// when you create the objects
Element<String> one = new Element();
Element<String> two = new Element();

// now both elements know about each other and they can be to whatever list/array etc they want
one.setOther(two);
two.setOther(one);