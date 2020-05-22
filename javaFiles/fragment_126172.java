public class NewClass {
    private int[] anArray = { 1, 2, 3, 4 };

    public int[] getAnArray() {
        return anArray;
    }
}

public class NewerClass {
    public static void main(String[] args) {
        NewClass myNewClass = new NewClass();
        sendToMethod(myNewClass.getAnArray());
    }
}