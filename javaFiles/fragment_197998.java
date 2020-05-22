package sample;

import java.util.ArrayList;

public class PersonRegister {
private static ArrayList<Person> regiter = new ArrayList<>();

    public void regitration (String name, String email, String phonennr, int year, int monht, int day, int age){
        Person onePerson = new Person(name,email,phonennr, year,monht,day,age);
        regiter.add(onePerson);

    }

    public ArrayList<Person> getRegiter(){
        return(regiter);
    }
}