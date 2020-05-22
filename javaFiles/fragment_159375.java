public class MainClass {
    int value;

    public void printValue() {
        System.out.println("" + value);
    }

    public static void main(String[] args){
        MainClass o = new MainClass();
        o.printValue();
    }
}