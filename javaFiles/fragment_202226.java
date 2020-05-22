package testbench;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class MyClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;

    public MyClass(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(lastName);
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        lastName = in.readUTF();
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

}