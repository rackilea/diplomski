private MyDate birthdate;


public Person(String name, int month, int day, int year) {
    birthday bDay = new birthday(month, day, year);
    this.birthdate = bDay.GetBirthday();
    this.name = name;

}