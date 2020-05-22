import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    static List<Data> read() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        List<Data> list = new ArrayList<>();
        String line;
        Data data = null;
        while ((line = reader.readLine()) != null) {
            if (line.matches("\\s*")) {
                continue; // skip blank lines
            }
            // Assume line that begins with space is a course.
            if (Character.isSpaceChar(line.charAt(0))) {
                //  Add new course to data if it's there.
                if (data == null) {
                    System.err.println("Missing serial for course " + line);
                } else {
                    data.courses.add(line);
                }
            } else {
                // Add completed data to list if there is one.
                if (data != null) {
                    list.add(data);
                }
                // Make new data with this serial.
                data = new Data(line);
            }
        }
        // Add the last data to the list if there is one.
        if (data != null) {
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            // Read.
            List<Data> list = read();

            // Sort based on serials.
            Collections.sort(list, new Comparator<Data>() {
                @Override
                public int compare(Data a, Data b) {
                    return a.serial.compareTo(b.serial);
                }
            });

            // Print.
            for (Data data : list) {
                data.print();
            }
        } catch (Exception ex) {
            System.err.println("Read failed.");
        }
    }
}

// Local class to hold data: a serial and related courses.
class Data {

    String serial;
    List<String> courses;

    Data(String serial) {
        this.serial = serial;
        courses = new ArrayList<>();
    }

    void print() {
        System.out.println(serial);
        for (String course : courses) {
            System.out.println(course);
        }
    }
}