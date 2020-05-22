public Person(Person sourcePerson) {
    //copy all field values (you didn't write what are your fields so I might not be 100% accurate here)
    this.name = sourcePerson.name;
    this.image = sourcePerson.image; //I don't know what type of data is stored in image so I'll just assume it's a String url path to an image
    this.age = sourcePerson.age;
    this.amount = sourcePerson.amount;
}