import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Runner {

    Map<Integer, String> decodebook = new HashMap<Integer, String>();
// List<Integer> numbers = new LinkedList<Integer>();
    Map<String, List<Integer>> codebook = new HashMap<String, List<Integer>>();
    Map<String, List<Integer>> subcodebook = new HashMap<String, List<Integer>>();
    List<Integer> numbers = new LinkedList<Integer>();
    List<Integer> otherNumbers = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        new Runner();
    }

    public Runner() throws IOException {

        numbers.add(6);
        numbers.add(156);
        numbers.add(363);
        numbers.add(336);
        numbers.add(26);
        numbers.add(61);

        otherNumbers.add(68);
        otherNumbers.add(78);
        otherNumbers.add(28);
        otherNumbers.add(668);
        otherNumbers.add(618);
        otherNumbers.add(686);
        otherNumbers.add(682);

        // ---------------------------------------------------------
        //
        //  the imprtant part
        // 
        // ------------------------------------------------------------
        subcodebook.put("tony", new ArrayList(numbers.subList(0, 2)));
        subcodebook.put("alf", new ArrayList(numbers.subList(3, 5)));

        codebook.put("alf", numbers);
        codebook.put("tony", otherNumbers);
        decodebook.put(7898, "alf");
        decodebook.put(87576, "tony");

        saveStuff();
        System.out.println(" codebook" + codebook);
        System.out.println(" decodebook" + decodebook);
        System.out.println(" subCodebook" + subcodebook);
        loadBooks();
        System.out.println(" codebook" + codebook);
        System.out.println(" decodebook" + decodebook);
        System.out.println(" subCodebook" + subcodebook);
    }

    public void loadBooks() throws IOException {

        loadCodeBook("CodeBook");
        //System.out.println(codebook);

        loadsubCodeBook("subcodeBook");

        loadDeCodeBook("DecodeBook");
        // System.out.println(codebook);
        //System.out.println(decodebook);

    }

    public Map<String, List<Integer>> loadCodeBook(String filePath)
            throws IOException {
        HashMap<String, List<Integer>> codebook = null;
        InputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(filePath));
            codebook = (HashMap<String, List<Integer>>) ((ObjectInputStream) is)
                    .readObject();
        } catch (Exception ex) {
        } finally {
            is.close();
        }
        return this.codebook = codebook;
    }

    public Map<String, List<Integer>> loadsubCodeBook(String filePath)
            throws IOException {
        HashMap<String, List<Integer>> subcodebook = null;
        InputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(filePath));
            subcodebook = (HashMap<String, List<Integer>>) ((ObjectInputStream) is)
                    .readObject();
        } catch (Exception ex) {
        } finally {
            is.close();
        }
        return this.subcodebook = subcodebook;
    }

    public Map<Integer, String> loadDeCodeBook(String filePath)
            throws IOException {
        HashMap<Integer, String> decodebook = null;
        InputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(filePath));
            decodebook = (HashMap<Integer, String>) ((ObjectInputStream) is)
                    .readObject();
        } catch (Exception ex) {
        } finally {
            is.close();
        }
        return this.decodebook = decodebook;
    }

    public void saveStuff() {
        try {
            saveCodeBook(codebook, "CodeBook");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {

            saveDecodeBook(decodebook, "DecodeBook");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {

            savesubCodeBook(subcodebook, "subcodeBook");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void saveCodeBook(Map<String, List<Integer>> obj, String filePath)
            throws IOException {
        OutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(filePath));

            ((ObjectOutputStream) os).writeObject(obj);
        } catch (Exception ex) {
        } finally {
            os.close();
        }
    }

    public void savesubCodeBook(Map<String, List<Integer>> obj, String filePath)
            throws IOException {
        OutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(filePath));

            ((ObjectOutputStream) os).writeObject(obj);
        } catch (Exception ex) {
        } finally {
            os.close();
        }
    }

    public void saveDecodeBook(Map<Integer, String> obj, String filePath)
            throws IOException {
        OutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(filePath));

            ((ObjectOutputStream) os).writeObject(obj);
        } catch (Exception ex) {
        } finally {
            os.close();
        }
    }

}