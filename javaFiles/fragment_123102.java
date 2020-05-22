public Person(String name){
    this(name, 18, "Atlanta");
}

public Person(String name, int age){
    this(name, age, "Atlanta");
}

public Person(String name, int age, String homeTown){
    this.name = name;
    this.age = age;
    this.homeTown = homeTown;   
}