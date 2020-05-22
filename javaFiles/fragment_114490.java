import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class test {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        JComboBox box = new JComboBox();
        fillComboBox(box, "C:\\path\\test.txt");
        JOptionPane.showMessageDialog(null, box);

    }

    private static void fillComboBox(JComboBox combobox, String filepath) throws FileNotFoundException, IOException {

        BufferedReader input = new BufferedReader(new FileReader(filepath));
        List<String> strings = new ArrayList<String>();
        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, file " + filepath + " didn't exist.");
        } finally {
            input.close();
        }

        String[] lineArray = strings.toArray(new String[] {});

        for (int i = 0; i < lineArray.length - 1; i++) {
            combobox.addItem(lineArray[i]);
        }

    }
}