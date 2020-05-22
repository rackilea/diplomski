import java.io.*;
import java.util.*;

public class SaveData {
    int counter = 1;

    public void saveTheData(ArrayList<myClass> myClassObj) {
        try {
            FileOutputStream fout = new FileOutputStream(counter
                    + "SaveGame.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(myClassObj);
            counter++;
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<myClass> loadTheData(int saveNum) {
        try {
            FileInputStream fin = new FileInputStream(saveNum + "SaveGame.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList<myClass> myClassObj = (ArrayList<myClass>) ois.readObject();
            ois.close();
            return myClassObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}