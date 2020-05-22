package de.professional_webworkx.jackson.jacksondemo;

import de.professional_webworkx.jackson.jacksondemo.domain.Person;
import de.professional_webworkx.jackson.jacksondemo.domain.Position;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class App {

    public static final File FILENAME = new File("position.json");

    public static final void main(String[] args) {
        LocalDate birthday = LocalDate.of(1980, 1, 1);
        Person person = new Person("Patrick", "Ott", "patrick.ott@professional-webworkx.de");

        Position position = new Position(48.113345, 11.273829);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(FILENAME, position);
            // here i read the position from the *.json file
            Position readValue = mapper.readValue(FILENAME, Position.class);
            System.out.println(readValue.getLat() + "N, " + readValue.getLon() + "E" );
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}