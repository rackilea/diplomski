import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class PhoneBook extends Frame implements ActionListener, ItemListener {

    private static final long serialVersionUID = 1L;
    MenuItem newMI, openMI, saveMI, saveAsMI, exitMI;
    MenuItem searchMI, deleteMI, updateMI, newEntryMI, sortMI;
    String fileName;
    // firstname, lastname and phonenumber are all combined now
    List entries;
    TextField lastName, firstName, phoneNumber;

    /**
     * Constructor
     */
    public PhoneBook() {
        super("White Pages"); // set frame title
        setLayout(new BorderLayout()); // set layout

        // create menu bar
        MenuBar menubar = new MenuBar();
        setMenuBar(menubar);
        // create file menu
        Menu fileMenu = new Menu("File");
        menubar.add(fileMenu);
        newMI = fileMenu.add(new MenuItem("New"));
        newMI.addActionListener(this);
        openMI = fileMenu.add(new MenuItem("Open"));
        openMI.addActionListener(this);
        fileMenu.addSeparator();
        saveMI = fileMenu.add(new MenuItem("Save"));
        saveAsMI = fileMenu.add(new MenuItem("Save As ..."));
        fileMenu.addSeparator();
        exitMI = fileMenu.add(new MenuItem("Exit"));
        exitMI.addActionListener(this);

        // create edit menu
        Menu editMenu = new Menu("Edit");
        menubar.add(editMenu);
        updateMI = editMenu.add(new MenuItem("Update"));
        updateMI.addActionListener(this);
        newEntryMI = editMenu.add(new MenuItem("New Entry"));
        newEntryMI.addActionListener(this);
        deleteMI = editMenu.add(new MenuItem("Delete"));
        deleteMI.addActionListener(this);
        editMenu.addSeparator();
        searchMI = editMenu.add(new MenuItem("Search"));
        searchMI.addActionListener(this);
        sortMI = editMenu.add(new MenuItem("Sort"));
        sortMI.addActionListener(this);

        // create phone list and controls
        Panel listPanel = new Panel(new BorderLayout());
        add(listPanel, BorderLayout.CENTER);
        Label label = new Label("Name List", Label.LEFT);
        listPanel.add(label, BorderLayout.NORTH);
        entries = new List();
        entries.addItemListener(this);
        listPanel.add(entries, BorderLayout.CENTER);
        Panel panel = new Panel(new BorderLayout());
        add(panel, BorderLayout.WEST);
        Panel editPanel = new Panel(new GridLayout(6, 1));
        panel.add(editPanel, BorderLayout.NORTH);
        label = new Label("Last Name", Label.LEFT);
        editPanel.add(label);
        lastName = new TextField();
        editPanel.add(lastName);
        label = new Label("First Name", Label.LEFT);
        editPanel.add(label);
        firstName = new TextField();
        editPanel.add(firstName);
        label = new Label("Phone Number", Label.LEFT);
        editPanel.add(label);
        phoneNumber = new TextField();
        editPanel.add(phoneNumber);
    }

    // implementing ActionListener
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == newMI) {
            entries.removeAll();
            fileName = null;
            display(-1);
            setTitle("White Pages"); // reset frame title
        } else if (source == openMI) {
            doOpen();
        } else if (source == exitMI) {
            System.exit(0);
        } else if (source == updateMI) {
            int index = entries.getSelectedIndex();
            // combine fields into one entry
            String entry = String.format("%s %s %s", lastName.getText().trim(),
                    firstName.getText().trim(), phoneNumber.getText().trim());
            if (index < 0) {
                // add a new entry
                entries.add(entry);
                entries.select(entries.getItemCount() - 1);
            } else {
                // update an existing entry
                entries.replaceItem(entry, index);
                entries.select(index);
            }
        } else if (source == newEntryMI) {
            entries.select(-1);
            display(-1);
        } else if (source == searchMI) {
            String searchName = JOptionPane.showInputDialog(this,
                    "Please enter a name (last first) to search:");
            System.out.println("Name to search: " + searchName);
        } else if (source == deleteMI) {
            // just delete the selected entry
            int index = entries.getSelectedIndex();
            if (index >= 0) {
                entries.remove(index);
            }
        } else if (source == sortMI) {
            String[] sortedEntries = entries.getItems();
            Arrays.sort(sortedEntries);
            entries.removeAll();
            for (String entry : sortedEntries) {
                entries.add(entry);
            }
        }
    }

    /**
     * Implementing ItemListener to display the selected entry
     */
    public void itemStateChanged(ItemEvent event) {
        display(entries.getSelectedIndex());
    }

    /**
     * method to specify and open a file
     */
    private void doOpen() {
        // display file selection dialog
        FileDialog fDialog = new FileDialog(this, "Open ...", FileDialog.LOAD);
        fDialog.setVisible(true);
        // Get the file name chosen by the user
        String file = fDialog.getFile();
        // If user canceled file selection, return without doing anything.
        if (file == null)
            return;
        fileName = fDialog.getDirectory() + file;

        // Try to create a file reader from the chosen file.
        FileReader reader;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File Not Found: " + fileName,
                    "Error", JOptionPane.ERROR_MESSAGE);
            doOpen();
            return;
        }
        BufferedReader bReader = new BufferedReader(reader);
        // remove items from before if any
        entries.removeAll();
        // Try to read from the input file one line at a time.
        try {
            int index;
            String textLine = bReader.readLine();
            while (textLine != null) {
                index = textLine.indexOf((int) ',');
                if (index > 0) {
                    String name = textLine.substring(0, index);
                    String number = textLine.substring(index + 1);
                    entries.add(String.format("%s %s", name.trim(),
                            number.trim()));
                }
                textLine = bReader.readLine();
            }
            bReader.close();
            reader.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this,
                    "Error reading file: " + ioe.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        setTitle("White Pages: " + file); // reset frame title
        entries.select(0);
        display(0);
    }

    /**
     * method to display the current entry
     */
    private void display(int index) {
        if (index < 0) {
            lastName.setText("");
            firstName.setText("");
            phoneNumber.setText("");
        } else {
            // use a regular expression and the split method to
            // split the entry on comma or whitespace 
            String[] fields = entries.getItem(index).split("(,|\\s)");
            if (fields.length > 0) {
                lastName.setText(fields[0]);
            }
            if (fields.length > 1) {
                firstName.setText(fields[1]);
            }
            if (fields.length > 2) {
                phoneNumber.setText(fields[2]);
            }
        }
    }

    /**
     * the main method
     */
    public static void main(String[] argv) {
        // create frame
        System.out.println("Creating window ... ");
        PhoneBook frame = new PhoneBook();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(size.width / 2, size.height / 2);
        frame.setLocation(100, 100);

        System.out.println("Your Screen Size: " + size.width + " (width) x "
                + size.height + " (height)");

        // add window closing listener
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // show the frame
        frame.setVisible(true);
    }
}