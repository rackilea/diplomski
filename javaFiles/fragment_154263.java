public class MyClass implements Runnable {

    private List<Integer> myList;

    public MyClass(List<Integer> myList) {
        this.myList = myList; //Constructor for the class
    }

    @Override
    public void run() {
        //your code here
    }
}