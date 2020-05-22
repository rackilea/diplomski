import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class GuiInterface {

    private JFileChooser ourFileSelector = new JFileChooser();
    private JTable table = new JTable();

    public GuiInterface() {
        Action openAction = new AbstractAction("Open Subtitle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ourFileSelector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                ourFileSelector.showSaveDialog(null);
                File ourSrtFile = ourFileSelector.getSelectedFile();
                String srtPath = ourSrtFile.getAbsolutePath();
                DefaultTableModel model = createModel(srtPath);
                table.setModel(model);
            }
        };
        JButton button = new JButton(openAction);
        JFrame frame = new JFrame();
        JScrollPane scroll = new JScrollPane(table);
        //scroll.setPreferredSize(new Dimension(200, 300));
        frame.add(scroll);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private DefaultTableModel createModel(String srtPath) {
        String[] columnNames = {"#", "Start", "End", "Translation column"};

        int maxLine = ReadFile.maxLine(srtPath);  // debug
        //Object[][] data = new Object[maxLine][];
        System.out.println(maxLine);  // debug

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        ArrayList<String> ends = ReadFile.getFileEndingTime(srtPath);
        ArrayList<String> starts = ReadFile.getFileStartingTime(srtPath);
        ArrayList<String> subs = ReadFile.readSubtitles(srtPath);
        for (int i = 0; i < ReadFile.maxLine(srtPath) - 1; i++) {
            model.addRow(new Object[] {starts.get(i), ends.get(i), subs.get(i)});
        }


        return model;
    }

    public static void main(String[] aregs) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiInterface();
            }

        });
    }
}

class ReadFile {

    public static ArrayList<String> getFileStartingTime(String file) {
        ArrayList<String> Lines = new ArrayList<String>();
        //String file = "tra.srt";
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                if (line.indexOf(':') != -1 && line.indexOf(',') != -1 && line.indexOf('0') != -1) {
                    Lines.add(line.substring(0, 12));
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return Lines;
    }

    public static ArrayList<String> getFileEndingTime(String file) {
        ArrayList<String> Lines = new ArrayList<String>();
        //String file = "tra.srt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf(':') != -1 && line.indexOf(',') != -1 && line.indexOf('0') != -1) {
                    Lines.add(line.substring(18, 29));
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return Lines;

    }

    public static ArrayList<String> readSubtitles(String file) {
        ArrayList<String> Lines = new ArrayList<String>();
        try {

            //String file = "tra.srt";
            Charset charset = Charset.defaultCharset();
            Path path = Paths.get(file);

            byte[] encoded = Files.readAllBytes(path);
            String data = charset.decode(ByteBuffer.wrap(encoded)).toString();

            Pattern p = Pattern.compile("(\\d+:\\d+:\\d+,\\d+) --> (\\d+:\\d+:\\d+,\\d+)\\s*(.*?)\\s*(^$|\\Z)", Pattern.DOTALL | Pattern.MULTILINE);
            Matcher m = p.matcher(data);

            while (m.find()) {
                //String startTime = m.group(1);
                //String endTime = m.group(2);
                //String subtitle = m.group(3);
                Lines.add(m.group(3));
                //System.out.println(startTime);
                //System.out.println(endTime);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return Lines;
    }

    public static ArrayList<String> ArraylineLengths(String file) {
        ArrayList<String> Lines = new ArrayList<String>();
        //String file = "tra.srt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                line = line.replace("\uFEFF", "");
                if (isInteger(line)) {
                    int i = Integer.parseInt(line);
                    if (i > 0) {
                        Lines.add(line);

                    }
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
        return (Lines);

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static int maxLine(String file) {
        try {

            //String file = "tra.srt";
            int max = 0;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            String line;
            while ((line = br.readLine()) != null) {
                if (isInteger(line)) {

                    max++;
                }
            }
            return max + 1;
        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return 0;

    }

}