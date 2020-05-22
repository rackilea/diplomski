public class Stack {
    static Vector r1 = new Vector<String>();

    public static void main(String[] args) {

        r1.add("O1");
        r1.add("O3");

        System.out.println(foo("O3"));
    }

    public static int foo(String o){
        int num = 0;
        System.out.println("in : " + r1);
        if(r1.contains("O3"))
            num++;
        else
            System.out.println(r1);
        return num;
    }
}