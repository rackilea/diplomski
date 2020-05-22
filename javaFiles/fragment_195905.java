class SomeClass extends BaseClass{
    String field = "some value";

    SomeClass(String data){ //constructor
        super(data);

        System.out.println(field);
    }
}