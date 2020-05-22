String a = "hello"; // a is a reference to the "hello" string object

String b = a; // b is a reference to the same "hello" string object

a = "bye"; // a is updated to reference the "bye" string object
           // b is still referencing the "hello" string object

System.out.println(b); // "hello" is printed