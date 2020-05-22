class MyObject {

    int id;
    int[] zero_Or_MoreArguments;

    MyObject(int id, int... zero_Or_MoreArguments) {
        this.id = id;
        this.zero_Or_MoreArguments = zero_Or_MoreArguments;
    }

    public static void main(String[]args) {
        MyObject mo = new MyObject(1, 2, 3, 4);
        System.out.println(Arrays.toString(mo.zero_Or_MoreArguments)); // prints [2, 3, 4]
    }
}