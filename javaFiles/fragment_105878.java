public class yourGUI {
    private JLabel progressLabel;

    public static void main(String[] args) {
       progressLabel = new JLabel();
       progressLabel.setBounds(137, 11, 200, 14);
       frame.getContentPane().add(progressLabel);
    }

    public static void displayText(int Stage) {
        String txt = "";
        if (Stage == 1) {
            txt = "Checking Cache...";
        } else if (Stage == 2) {
            txt = "Downloading Cache...";
        } else if (Stage == 3) {
            txt = "Cache Download Complete!";
        } else if (Stage == 4) {
            txt = "Unpacking Files...";
        } else {  //assuming (Stage == 5), this is up to your discretion 
            txt = "Launching Client!";
        }
        progressLabel.setText(txt);
    }
}