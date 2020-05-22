import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame {

    public static JComboBox<Person> peopleBox;

    public App() {
        try {
            loadList();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            saveList(Person.peopleList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateData(){
        peopleBox = new JComboBox<>();
        peopleBox.setModel(getComboBoxModel(Person.peopleList));
        add(peopleBox);
        pack();
    }

    public DefaultComboBoxModel<Person> getComboBoxModel(ArrayList<Person> peopleList) {
        Person[] comboBoxModel = peopleList.toArray(new Person[0]);
        return new DefaultComboBoxModel<>(comboBoxModel);
    }

    public static void saveList(ArrayList<Person> peopleList) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.bin"));
        objectOutputStream.writeObject(peopleList);
    }

    public static void loadList() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.bin"));
        Person.peopleList.addAll((List<Person>) objectInputStream.readObject());
    }

    public static void main(String[] args) {
        App app = new App();
        Person p = new Person("Sean2", 24);
        try {
            saveList(Person.peopleList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        app.updateData();
        app.setVisible(true);
    }
}