package stream;

public class OneTimePrinter {
    private boolean shouldPrint = true;

    public void print(Object o){
        if (shouldPrint){
            System.out.println(o);
            shouldPrint = false;
        }
    }
}