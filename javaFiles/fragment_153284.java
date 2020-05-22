import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ClassData {

    private String name;
    private ArrayList<String> methods;

    public ClassData() {
        methods = new ArrayList<>();
    }

    public void setName(String cName) {
        name = cName;
    }

    public String getName() {
        return name;
    }

    public void addMethod(String mName) {
        methods.add(mName);
    }
    public void setMethods(ArrayList<String> m)
    {
        methods.addAll(m);
    }

    public ArrayList<String> getMethods() {
        return methods;
    }

    public static void main(String[] args) {
        ClassData cObj = new ClassData();
        cObj.setName("This_is_name");
        cObj.addMethod("m1");
        String fileName = cObj.getName() + ".xml";

        XMLEncoder enc = null;

        try {
            enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("Unable to save file.");
        }

        enc.writeObject(cObj);
        enc.close();

    }

}