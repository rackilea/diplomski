class SomeClass{

    public static void main(String[] args) {

        ToBeImplemented someImplementation;

        //now you can pick an implementation, based on user input for example
        if (userInput == something) 
           someImplementation = new ImplementationA();
        else
           someImplementation = new ImplementationB();

        //do some staff

        //Regardless of the user input, main method only knows about the
        //abstract "ToBeImplemented", and so calls the .doThis() method of it
        //and the right method gets called based on the user input.
        someImplementaion.doThis();
        //at That

    }

}