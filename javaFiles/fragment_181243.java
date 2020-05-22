public class TextAreaWrite extends JFrame{

private JTextArea area = new JTextArea();

public TextAreaWrite(){
    setLayout(new BorderLayout());
    area.setText("Hi \n bye");
    add(area, BorderLayout.CENTER);
    JButton button = new JButton("write");
    button.addActionListener(new ButtonHandler());
    add(button, BorderLayout.SOUTH);
    setVisible(true);
}

private class ButtonHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Create the path to the file
        File file = new File("C:\\text.txt");
        try {
            //create the file if it doesn't exist
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //create a stream from the file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Create a printWriter from the fileOutputStream
        PrintWriter writer = new PrintWriter(fos);
        //get the text from the text area and split it into an array splitting at the new line character
        //so that eash line from the textArea is in the array
        String[] text = area.getText().split("\n");
        //And now print all the lines from the textArea onto the lines in the textfile
        int c = 0;
        while(c < text.length){
            writer.println(text[c]);
            c++;
        }
        //flush to make sure the data is send
        writer.flush();
        //close our resources
        writer.close();
    }
}

public static void main(String[] args){
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            new TextAreaWrite();
        }
    });
}