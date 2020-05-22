import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Threadexample {

    // Hashtable and Keylist
    private Hashtable<String, Integer> table;
    private CopyOnWriteArrayList<String> keys;

    // Konstruktor
    public Threadexample() {
        table = new Hashtable<String, Integer>();
        keys = new CopyOnWriteArrayList<String>();
    }

    // Adds an Item to the Table and prints the table
    public synchronized void addItem(String key, int value, String threadname) {
        // Adding
        table.put(key, value);
        if (!isAlreadyAdded(key)) {
            keys.add(key);
        }else{
        return;
        }
        System.out.println(threadname + "-> Added! Key: " + key + " Value: " + value);
        // Showing
        showItems(threadname);
    }

    // Bewares of doublicate keys in the keylist
    private boolean isAlreadyAdded(String key) {
        int size = keys.size();
        for (int i = 0; i < size; i++) {
            if (keys.get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Prints out all Integer with their keys
    private void showItems(String threadname) {
        Set<String> keys = table.keySet();
        for (String key : keys) {
            System.out.println(threadname + "-> Key: " + key + "   Value: " + table.get(key));
        }
        System.out.print(System.getProperty("line.separator"));
    }

    // Mainmethod
    public static void main(String[] args) {
        final Threadexample tex = new Threadexample();
        final String[] keyarray = new String[] { "Zero", "One", "Two" };

        // starts 3 Threads which are adding and showing the Objects
        for (int i = 0; i < 3; i++) {
            final int value = i;

            new Thread() {
                public void run() {
                    setName("Thread: " + (value + 1));
                    tex.addItem(keyarray[value], value, getName());
                }
            }.start();

            try {
                // Leave every Thread enough time to work
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }

    }
}