import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {

    public Test() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(new File("C:\\usr\\test.csv")));
            List<String[]> elements = new ArrayList<String[]>();
            String line = null;
            while((line = br.readLine())!=null) {
                String[] splitted = line.split(";");
                elements.add(splitted);
            }
            br.close();

            JTable table = new JTable();
            String[] columNames = new String[] {
                    "ID", "Country", "Status", "Person"
                };

            Object[][] content = new Object[elements.size()][4];

            for(int i=0; i<elements.size(); i++) {
                content[i][0] = elements.get(i)[0];
                content[i][1] = elements.get(i)[1];
                content[i][2] = elements.get(i)[2];
                content[i][3] = elements.get(i)[3];
            }

            table.setModel(new DefaultTableModel(content,columNames));

            System.out.println(table.getModel().getValueAt(1, 1));

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Test();
    }
}