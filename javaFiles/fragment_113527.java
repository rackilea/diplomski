class Animal{
    Animal(int){

    }
}

class Dog extends Animal
{
    Dog(){
        // right here compiler will place an implicit call to super() ; not seen, at compile time.
        // since there is no no-args constructor available in class Animal compiler will issue a warning and stop compiling. Remember that a no-args constructor is provided by default ONLY if no other constructor was provided by the programmer. In this example we have a constructor in our superclass that takes an int as argument and so we must explicitly tell the compiler to call super(24);
    }
}