class Foo{

private int x;
private String name;

    Foo(int x){      //constructor 1
        this(x, "Default Name");
    }
    Foo(String name){  //constructor 2
        this(0, name);
    }
    Foo(int x, String name){  //constructor 3
        this.x = x;
        this.name = name;
    }
}

Foo f1 = new Foo(9); //calls constructor 1, who will call constructor 3
                     //f1.x = 9, f1.name = "Default Name"
Foo f2 = new Foo("Test"); // calls constructor 2, who will call constructor 3
                          // f2.x = 0; f2.name = "Test"
Foo f3 = new Foo(3, "John"); //calls constructor 3
                             // f3.x = 3; f3.name = "John"

Foo f4 = new Foo()  // This won't work! No default Constructor provided!