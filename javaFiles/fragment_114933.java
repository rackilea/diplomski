class MyClass{
    public static void myMethod(int i){
        System.out.println("myMethod1(int)");
    }
    public static void myMethod(double a){
        System.out.println("myMethod2(int)");
    }   
}

class Demo{
    public static void main(String args[]){
        MyClass.myMethod(100);
    }
}