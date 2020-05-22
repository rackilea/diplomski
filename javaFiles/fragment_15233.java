public class WhateverClass{

    //this is the first constructor
    public WhateverClass(){

        System.out.prinln("A message");

    }

    //this is the second constructor
    public WhateverClass(String message){

        System.out.prinln(message);

    }

    //this is the main method
    public static void main (String[] args){
        new WhateverClass(); //will print the message
        new WhateverClass("A message");
    }
}