class A{

    void methodA(){
        //Some logic
    }

    public static void methodB(){
        //Some logic
    }
}

public static void main(String args[]){

    A obj = new A();
    obj.methodA(); // You can use methodA using Object only.

    A.methodB();  // Whereas static method can be accessed by object as well as 
    obj.methodB(); // class name.
}