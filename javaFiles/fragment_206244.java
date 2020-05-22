/*
  In this modified example, the Database connection is opened 
  and closed before and after every DB access operation. I don't
  think Connection Pooling is required here....yet.

  The image used in the Login Dialog can be downloaded from here:
             https://www.freeiconspng.com/img/3059
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TaskViewer extends JFrame {

    // Class global member variables
    private String applicationUserName;         // Will hold the logged in User      Name.
    private String applicationUserPassword;     // Will hold the Logged in User Password.

    // Constructor
    public TaskViewer() {
        // Keep it tidy and simple.
        initializeTaskViewer();
    }

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TaskViewer().startApp(); // Don't need static methods this way.
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void startApp() {
        /* 
          View the TaskView application window. The Event Dispatch 
          Thread (EDT) doesn't actually let this happen until this 
          method is finished so, all you will see is the Login Dialog
          when the application starts and validation is satisfied.
          Since we extend JFrame in this Class, we don't have to 
          instantiate as new TaskView. Doing so will just wipe out the
          class member variables we had set with our Login Dialog 
          since it would now be a new instance of TaskView.
        */
        setVisible(true);
        String message = "<html>Please supply your Login information. If "
                + "you are<br>a New User then you will be automatically added<br>"
                + "to the database.<br><br><br>";
        String title = "TaskView - User Login ...";
        String userNameCaption = null; //"User Name:";
        String passwordCaption = null; //"Password:";
        String footNoteCaption = "<html><pre><font size=2>                  "
                + "Select <font color=red>Cancel</font> to quit</font></pre><br></html>";
        Color backColor = Color.decode("#ffe6cc");  // our custom background color.
        //Object dialogImage = JOptionPane.QUESTION_MESSAGE;  // You can do it this way...
        // or this way...
        Object dialogImage = "login-icon-3059.png|80,80";  // get image from: https://www.freeiconspng.com/img/3059
        // The text captions for our dialog buttons
        Object[] buttonCaptions = {"<html><font color=red>Login</font> To TaskView</html>",
            "<html><font color=red>Cancel</font> - Quit</html>"};

        // The call to our Custom Login Dialog
        String[] loginPass = customLoginInputBox(null, message, title, userNameCaption, passwordCaption,
                footNoteCaption, backColor, dialogImage, buttonCaptions);
        /* The call could very well look like this...
           String[] loginPass = customLoginInputBox(null, message, title, null, null, null, null, null, null);
           ...but the dialog looks pretty bland ;p  */

        if (loginPass[0] == null) {
            JOptionPane.showMessageDialog(this, "Login Not Supplied! Quiting...",
                    "Invalid Login", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        else {
            applicationUserName = loginPass[0];
            applicationUserPassword = loginPass[1];
        }

        boolean valid = validateLogin(applicationUserName, applicationUserPassword);
        if (!valid) {
            System.exit(0);
        }
    }

    private void initializeTaskViewer() {
        setTitle("TaskView v1.0.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 602, 402);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JTable table = new JTable();
        JButton btnLoadTable = new JButton("Load Tasks");
        btnLoadTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connection connection = null;
                try {
                    connection = SQLiteConnection.dbConnector();
                    String query = "SELECT * FROM Task WHERE Username = ?";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, applicationUserName); 
                    ResultSet rs = pst.executeQuery();
                    // Don't need dependency on DbUtil with this provided small method.
                    resultSetToJTable(table, rs); 
                    //table.setModel(DbUtils.resultSetToTableModel(rs)); //DbUtil is from rs2
                }
                catch (Exception e) {
                    Logger.getLogger(TaskViewer.class.getName()).log(Level.SEVERE, null, e);
                }
                finally {
                    try { 
                        // Closeing the connection will automatically 
                        // close pst and rs.
                        if (connection != null) { connection.close(); }
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(TaskViewer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        btnLoadTable.setBounds(34, 41, 100, 25);
        contentPane.add(btnLoadTable);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(177, 41, 376, 248);
        contentPane.add(scrollPane);
        // Set Appplication window in center of screen.
        // Must be done just before setVisible() is used.
        setLocationRelativeTo(null); 
    }

    /**
     * Displays a modal Custom Input Dialog Box where a User Name and Password
     * can be supplied.
     *
     * @param component             (Component) The parent component from where
     *                              the dialog will be displayed from. Null can
     *                              be supplied if there is no apparent parent
     *                              component. If null is supplied then a parent
     *                              is temporarily created to ensure visibility
     *                              and then disposed of when done.<br>
     *
     * @param message               (String) The message body to display within
     *                              the Login Dialog. The length of the message
     *                              strings (before and after line breaks) can
     *                              determine how large the dialog will become.
     *                              The use of line breaks can be pertinent
     *                              here. HTML can be used to create your
     *                              message.<br>
     *
     * @param title                 (String) The title to be displayed within
     *                              the Login Dialog window title bar. Only
     *                              plain text can be used here.<br>
     *
     * @param userNameBoxCaption    (String) The User Name entry text box
     *                              contains a text caption to the left of it so
     *                              as to indicate what the entry box is for. By
     *                              default this caption states: "User Name:".
     *                              If you want to change this default caption
     *                              then you can supply it here. If you prefer
     *                              to use the default then simply supply null.
     *                              HTML can be used here.<br>
     *
     * @param passwordBoxCaption    (String) The Password entry text box
     *                              contains a text caption to the left of it so
     *                              as to indicate what the entry box is for. By
     *                              default this caption states: "Password:". If
     *                              you want to change this default caption then
     *                              you can supply it here. If you prefer to use
     *                              the default then simply supply null. HTML
     *                              can be used here.<br>
     *
     * @param dialogFootNoteCaption (string) By default there is no footer
     *                              caption. The footer text caption is
     *                              displayed below and between the Password
     *                              entry box and the dialog buttons located at
     *                              the bottom of the dialog. Any additional
     *                              information can be supplied here if desired.
     *                              HTML can be used here as well.<br>
     *
     * @param dialogBackColor       (Color) You can set the desired background
     *                              color for your Login Dialog. By default is
     *                              would be the default Message Box color for
     *                              your specific Operating System or to
     *                              whatever Look & Feel currently being used by
     *                              your application. Any color can be supplied
     *                              as long as it is supplied as a Color
     *                              Object.<br>
     *
     * @param dialogImage           (Object) This parameter is a little special.
     *                              By default a standard JOptionPane Question
     *                              Message icon is displayed to the left side
     *                              of the Login Dialog. If you want to change
     *                              this icon to any one of the other
     *                              JOptionPane Icons then you can simply supply
     *                              any one of them here in the form of:<pre>
     *
     *      JOptionPane.ERROR_MESSAGE;
     *      JOptionPane.INFORMATION_MESSAGE
     *      JOptionPane.PLAIN_MESSAGE
     *      JOptionPane.QUESTION_MESSAGE
     *      JOptionPane.WARNING_MESSAGE</pre><br>
     *
     * If however you want to utilize your own custom image (transparent
     * background .png is best) then you can supply the path and file name of
     * your image to this parameter as string. You can also optionally preset a
     * specific size for your image by placing a Pipe (|) delimiter at the end
     * of the path string and supplying integer values for width and height, for
     * example:
     * <pre>
     *
     *     "C:\\My App Path\\Images\\logo.png|80,80"</pre><br>
     *
     * In the example image path string above we're telling the method to resize
     * the image to 80 pixels wide by 80 pixels high. The delimiter used to
     * separate the Width and Height in the above path string is a comma (,) but
     * can very well be a whitespace, a semicolon (;), or a colon (:). Any one
     * of the four will work as a Width/Height delimiter.<br><br>
     *
     * This parameter will accept either a integer value or a string value. If a
     * integer value is supplied then it will be assumed that a JOptionPane icon
     * is supplied. If a string value is supplied then it will be assumed that
     * it is the path to a custom image file located within the local file
     * system.<br>
     *
     * @param dialogButtonCaptions  (Single Dimensional (1D) Object[] Array)
     *                              There are only two buttons within the Login
     *                              Dialog and by default they are the "OK" and
     *                              "Cancel" buttons (cancel has default focus).
     *                              Both by default contain the aforementioned
     *                              respective text captions. If you want to
     *                              change these button captions then you can do
     *                              so here by supplying a object array of
     *                              button caption strings, for example:<pre>
     *
     *      Object[] buttonCaptions = {"Login To App", "Cancel/Quit"};</pre><br>
     *
     * HTML can be used in the caption strings.<br>
     *
     * @return (Single Dimensional (1D) String[] Array) The returned string
     *         array will only ever contain two specific elements, the supplied
     *         Login Name and the supplied Password. If null in either or both
     *         elements is returned then the dialog was canceled (right-most
     *         button selected) or the dialog was closed with the dialog window
     *         close [x] button. The dialog can not be closed unless proper
     *         credentials (name and password) are supplied or the dialog is
     *         canceled.
     */
    public String[] customLoginInputBox(Component component, String message, String title,
            String userNameBoxCaption, String passwordBoxCaption,
            String dialogFootNoteCaption, Color dialogBackColor,
            Object dialogImage, Object[] dialogButtonCaptions) {
        String[] result = {null, null};
        Object[] buttonCaptions = {"OK", "Cancel"};
        if (dialogButtonCaptions != null && dialogButtonCaptions.length > 0) {
            buttonCaptions = Arrays.copyOf(dialogButtonCaptions, dialogButtonCaptions.length);
        }
        Component comp = component;
        JFrame iFRAME = new JFrame();
        if (comp == null) {
            /* Create a dummy JFrame. This is done so that
               the Dialog box that is used in the application
               does not hide behind the IDE or ON TOP form if 
               null is used for the parent component. Not a 
               problem for some. 
             */
            iFRAME.setAlwaysOnTop(true);
            comp = iFRAME;
        }

        String userNameCaption = "User Name: ";  // Default caption
        if (userNameBoxCaption != null && !userNameBoxCaption.equals("")) {
            userNameCaption = userNameBoxCaption;
        }
        String passwordCaption = "Password:  "; // Default caption
        if (passwordBoxCaption != null && !passwordBoxCaption.equals("")) {
            passwordCaption = passwordBoxCaption;
        }
        // Default dialog footnote (no footnote).
        String footNote = dialogFootNoteCaption == null
                || dialogFootNoteCaption.equals("") ? " " : dialogFootNoteCaption;

        String uName = "";
        String passWrd = "";

        // Set dialog background to white. 
        Color origPanelColor = (Color) UIManager.get("OptionPane.background");
        Color origPaneBackgroundColor = (Color) UIManager.get("Panel.background");
        if (dialogBackColor != null) {
            try {
                 UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                UIManager.put("OptionPane.background", dialogBackColor);
                UIManager.put("Panel.background", dialogBackColor);
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger("customLoginInputBox() Method Error!").log(Level.SEVERE, null, ex);
            }
        }

        // Get User input as to User Name and Password.
        // using a custom Input Dialog...
        // Build the Login dialog Panel...
        BorderLayout layout = new BorderLayout();
        JPanel panel = new JPanel(layout);
        panel.setBackground(dialogBackColor);
        JLabel label = new JLabel(message);
        panel.add(label, BorderLayout.NORTH);
        JPanel p = new JPanel(new BorderLayout(5, 5));
        p.setBackground(dialogBackColor);
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        labels.setBackground(dialogBackColor);
        labels.add(new JLabel(userNameCaption, SwingConstants.RIGHT));
        labels.add(new JLabel(passwordCaption, SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        controls.setBackground(dialogBackColor);
        JTextField userName = new JTextField();
        controls.add(userName);

        JPasswordField password = new JPasswordField();
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);
        panel.add(p);
        JLabel baseLabel = new JLabel(footNote);
        panel.add(baseLabel, BorderLayout.SOUTH);

        // The custom Image to use in Login dialog...
        ImageIcon icon = null;
        int msgType = JOptionPane.QUESTION_MESSAGE;
        if (dialogImage != null && dialogImage.getClass().getSimpleName().toUpperCase().equals("STRING")) {
            String dString = dialogImage.toString();
            int sizeWidth = 0, sizeHeight = 0;
            if (dString.contains("|")) {
                String[] dsTmp = dString.split("\\|");
                dString = dsTmp[0];
                if (dsTmp[1].contains(",") || dsTmp[1].contains(";")
                       || dsTmp[1].contains(":") || dsTmp[1].contains(" ")) {
                    try {
                        sizeWidth = Integer.parseInt(dsTmp[1].split(",|;|:|\\s+")[0]);
                        sizeHeight = Integer.parseInt(dsTmp[1].split(",|;|:|\\s+")[1]);
                    }
                    catch (Exception e) {
                    }
                }
            }
            icon = new ImageIcon(dString);
            if (sizeWidth == 0) {
                sizeWidth = icon.getIconWidth();
            }
            if (sizeHeight == 0) {
                sizeHeight = icon.getIconHeight();
            }
            Image image = icon.getImage();

            // Size it to what you want (this example uses: 128 x 128).
            Image newimg = image.getScaledInstance(sizeWidth, sizeHeight, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
        }
        else if (dialogImage != null && dialogImage.getClass().getSimpleName().toUpperCase().equals("INTEGER")) {
            msgType = (int) dialogImage;
        }
        // Get Input from User. This will display 
        // your custom Input Dialog Box.
        while (uName.equals("") || passWrd.equals("")) {
            int res = JOptionPane.showOptionDialog(iFRAME, panel, title,
                    JOptionPane.OK_CANCEL_OPTION, msgType, icon, buttonCaptions, buttonCaptions[1]);

            // Process the result from our custom Input Dialog Box
            if (res == JOptionPane.OK_OPTION && !userName.getText().equals("")
                    && !Arrays.toString(password.getPassword()).equals("")) {
                uName = userName.getText();
                char[] pass = password.getPassword();
                for (int i = 0; i < pass.length; i++) {
                    passWrd += Character.toString(pass[i]);
                }
                if (uName.equals("") || passWrd.equals("")) {
                    Toolkit.getDefaultToolkit().beep();
                    continue;
                }
                // Do whatever you want with User Name and Password
                result[0] = uName;
                result[1] = passWrd;
            }
            else {
                if (res == 1 || res == -1) {
                    break;
                }
            }
        }

        iFRAME.dispose(); // Dispose of the temp parent for the dialog.

        // Set UI Colors back to original. 
        if (dialogBackColor != null) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                UIManager.put("OptionPane.background", origPanelColor);
                UIManager.put("Panel.background", origPaneBackgroundColor);
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger("customLoginInputBox() Method Error!").log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    private boolean validateLogin(String userName, String userPassword) {
        boolean isValid = false;
        Connection connection = SQLiteConnection.dbConnector();
        try {
            String query = "SELECT * FROM  User_Info WHERE Username = ? and Password = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, userName);
                pst.setString(2, userPassword);
                try (ResultSet rs = pst.executeQuery()) {
                    int count = 0;
                    while (rs.next()) {
                        if (rs.getString("Username").equals(userName) && 
                                rs.getString("Password").equals(userPassword)) {
                            isValid = true;
                            break;  // don't need loop any more
                        }
                    }
                }
                if (isValid) {
                    JOptionPane.showMessageDialog(this, "User name and password is correct!", 
                            "Login Valid", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(this, "User name or password is incorrect!",
                            "Login Invalid!", JOptionPane.ERROR_MESSAGE);
                    // You may want to add a mechanism to add new User to database here.
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try { 
                if (connection != null) { connection.close(); }
            }
            catch (SQLException ex) {
                Logger.getLogger(TaskViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isValid;
    }

    /**
     * Fills the supplied JTable with the Column Names and Data from a supplied
     * ResultSet.<br><br>
     *
     * @param table (JTable) The variable name of the JTable to fill.<br>
     *
     * @param rs    (ResultSet) The ResultSet to fill JTable from.
     */
    public void resultSetToJTable(JTable table, ResultSet rs) {
        try {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }
            Object[] row = new Object[columnCount];
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }
            table.setModel(tableModel);
        }
        catch (SQLException ex) {
            System.err.println("resultSetToJTable() Method Error! - "
                    + System.lineSeparator() + ex.getMessage());
        }
    }
}