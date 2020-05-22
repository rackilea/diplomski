package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class Main  {

    public static void main(String[] args) throws IOException {     
        Person person = FXMLLoader.load(Main.class.getResource("Person.fxml"));
        System.out.println(person.getFirstName()+" "+person.getLastName());
    }
}