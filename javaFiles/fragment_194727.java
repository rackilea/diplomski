class Box<T> {
    private T first;
    private T second;   

    //2-parameter constructor

    public void swapItems(){

        T temp = first;
        first = second;
        second = temp;
    }

    //getters and setters
}