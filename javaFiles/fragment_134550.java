public static void main(String[] args){
    Baa test=new Foo(); //a Foo is a Baa so no problem

    Baa getSomething=test.returnSomething(); //returns a Foo, but a foo can be used as as a baa so no problem

}