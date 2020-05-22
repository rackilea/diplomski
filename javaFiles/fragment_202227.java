package testbench;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class MyClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private String a1;
    private String a2;

    public MyClass(final String a1, final String a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeUTF(a1);
        out.writeUTF(a2);
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        a1 = in.readUTF();
        a2 = in.readUTF();
    }

    @Override
    public String toString() {
        return a1 + " " + a2;
    }

}