package serialTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class serialTest {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length > 0) {
            deSerialize();
        } else {
            employees.add(new Employee(1, "John", "Doe"));
            employees.add(new Employee(2, "Jane", "Doe"));
            serialize();
        }
    }

    private static void serialize() {
        System.out.println("Serializing...");
        try {
            try (FileOutputStream fos = new FileOutputStream("employeeData"); 
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject((Employee[]) employees.toArray(new Employee[employees.size()]));
            }
        } catch (IOException ioe) {
        }
    }

    private static void deSerialize() {
        System.out.println("DeSerializing...");
        try {
            try (FileInputStream fis = new FileInputStream("employeeData");
                    ObjectInputStream ois = new ObjectInputStream(fis)) {

                employees.addAll(Arrays.asList((Employee[]) ois.readObject()));
            }
        } catch (IOException ioe) {
            System.out.println("File problems");
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class problems");
            return;
        }

        for (Employee info : employees) {
            System.out.println(info);
        }
    }
}