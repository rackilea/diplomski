import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import au.com.bytecode.opencsv.CSVReader;

public class ReadFileDemo {

    private String defaultFile = "D:\\Book.txt";
    private File currentFile = new File(defaultFile);
    private JTable table;
    private CSVReader reader;
    private CharsetDecoder UTF8_CHARSET;

    public ReadFileDemo() {
        DefaultTableModel model = getModelFromCsvFile(currentFile, ";");
        table = new JTable(model);
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.add(getDelimiterComboBox(new String[] { ";", ".", "\t" }),
                BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Similar to your read() method
     */
    public DefaultTableModel getModelFromCsvFile(File file, String delimiter) {
        DefaultTableModel model = null;
        boolean isFirstRow = true;
        try {
            UTF8_CHARSET = StandardCharsets.UTF_8.newDecoder();
            UTF8_CHARSET.onMalformedInput(CodingErrorAction.REPLACE);
            reader = new CSVReader(new InputStreamReader(new FileInputStream(file),
                    UTF8_CHARSET), delimiter.charAt(0));
            List<String[]> dataList = reader.readAll();
            for (String[] row: dataList) {
                if (isFirstRow) {
                    model = new DefaultTableModel(getTableColumnHeaders(row.length), 0);
                    model.addRow(row);
                    isFirstRow = false;
                }
                else {
                    if (model != null) {
                        model.addRow(row);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    public JComboBox getDelimiterComboBox(String[] delimiters) {
        final JComboBox cbox = new JComboBox(delimiters);
        cbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String delimiter = cbox.getSelectedItem().toString();
                DefaultTableModel model = getModelFromCsvFile(currentFile,
                        delimiter);
                if (model != null) {
                    table.setModel(model);
                }
            }
        });
        return cbox;
    }

    public Object[] getTableColumnHeaders(int size) {
        Object[] header = new Object[size];
        for (int i = 0; i < header.length; i++) {
            header[i] = i + 1;
        }
        return header;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReadFileDemo();
            }
        });
    }
}