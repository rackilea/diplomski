class Person {    
    String lastName;
    String name;

    public Person(String lastName, String name){
        this.lastName = lastName;
        this.name = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getName(){
        return this.name;
    }
}