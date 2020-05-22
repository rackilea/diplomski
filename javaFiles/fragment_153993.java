Dog myDog = new Dog("Spike");
Object anyObject = myDog;
System.out.println(anyObject.toString());   //would print the result of your "toString()" method in the Dog class : 
                                            //"Hello! I am a dog called Spike"


Refrigerator myFridge = new Refrigerator();
Object secondObject = myFridge;
System.out.println(secondObject.toString());    //would print the result of your "toString()" method in the Refrigerator class : 
                                                //"I am a refrigerator"