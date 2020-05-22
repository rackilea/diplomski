class MyInteger{
    int num;

    public MyIntger(int num){
        this.num = num;
    }

    // Method 1
    public static boolean isOdd(int num){
        ...
    }

    // Method 2
    public boolean isOdd(){
        ...
    }

    // Method 3
    public static boolean isOdd(MyInteger num){
        ...
    }
}

public class TestMyInteger{
    public static void main(String[] args){

        // Method 1 call
        boolean odd1 = MyIntger.isOdd(5);    // static call

        // Method 3 call
        boolean odd2 = MyInteger.isOdd(new MyInteger(5));  // static call

        // Method 2 call
        MyIntger num = new MyIntger(5);  // create instance
        boolean odd3 = num.isOdd();   // instance call

        System.out.println(odd1);
        System.out.println(odd2);
        System.out.println(odd3);

    }
}