public class Todo<T>{ // T can represent Element or ElementImage or anything you want.
    T element;
    private List<T> list = new ArrayList<>();
    public Todo(T element){
        this.element = element;
    }

    T getElemet(){
        return element; // If T is ElementImage or just Element you can get it and do what you want

    }
    // Now you would need to add further logic and more stuff.
    public List<T> getTodoList(){ return list;}
}