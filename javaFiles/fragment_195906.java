class SomeClass extends BaseClass{
    String field = null;  // initialization is moved --+
                          //                           |
    SomeClass(String data){   //                       |
        super(data);          //                       |
        field = "some value"; // here <----------------+ 
        System.out.println(field);
    }
}