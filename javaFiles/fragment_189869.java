import java.io.Serializable;

// Define custom data
public class IntIntString implements Serializable {
    private static final long serialVersionUID = 1L;
    int int1;
    int int2;
    String string1;

    public void setData(int i1, int i2, String s1) {
        int1 = i1;
        int2 = i2;
        string1 = s1;
    }

    public void show() {
        System.out.println("Int1 = " + int1);
        System.out.println("Int2 = " + int2);
        System.out.println("String1 = " + string1);
    }
}