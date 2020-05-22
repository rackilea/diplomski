public class test {

    public int method1 () {
        ...some code...
        if (someValue == someValue2) {return -1;}
        ...more code...
        return 0;
    }

    public static void main(String[] args) {
        ...some code...

        if (method1() == 0) {
            ...more code...
        }
    }
}