public class Window extends JFrame implements ActionListener{

private JButton theButton = new JButton("Calculer sur 100");
//Change the next line to have a JEditorPane
private JEditorPane text = new JEditorPane();
private JTextField textField = new JTextField("Écrire un nombre");
private JScrollPane scroller = new JScrollPane(text);
private StringBuilder sb = new StringBuilder();
private Style style;

public Window() {
    setLayout(new BorderLayout());
    setTitle("Test");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    //This line was added
    text.setContentType("text/html");

    theButton.addActionListener(this);

    getContentPane().add(scroller, BorderLayout.CENTER);
    getContentPane().add(textField, BorderLayout.NORTH);
    getContentPane().add(theButton, BorderLayout.SOUTH);
    setVisible(true);
}

/**
 * Prints the result on text
 * @param num
 */
private void print100(int num) {
    for (int i = 1; i < num + 1; i++) {
        text.setText(appendString(i));
    }
}

/**
 * convert the number to string 
 * @param i
 * @return a string that contains the information
 */
private String appendString(int i){
    double a = doMath(i, checkForNumber());

    String s = "";
    if(a < 60){
        //This line changed
        s = "<br><span style=\"color:red\">" + i + " : " + a + "</span>";//This need to be red
    }
    else
        s = "<br>" + i + " : " + a;

    return sb.append(s).toString();
}

/**
* Check if the text in the text is numbers
* return numl
*/
private int checkForNumber() {
    int numl;
    try {
        numl = Integer.parseInt(textField.getText());
    } catch (NumberFormatException e) {
        text.setText("Essayer avec des nombres...");
        return 0;
    }
    return numl;
}

/**
* leave specific number of digit after the dot
* return myNum
*/
private double doMath(int i, int num) {
    double myNum = ((double) i / num) * 100;
    int precision = 100; //Number of zero = number of digits
    myNum = Math.floor(myNum * precision + .5) / precision;
    return myNum;
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == theButton) {
        text.setText("");
        print100(checkForNumber());
    }
}