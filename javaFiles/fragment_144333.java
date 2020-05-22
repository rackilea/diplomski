package framedemo;

import javax.swing.*;

public class FrameDemo {

    JTextArea textArea;
    private final static String newline = "\n";

    public FrameDemo() {
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);        
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
    }


    public void showMessage(String message){
        textArea.append(message + newline);
    }

    public static void main(String[] args) {
        FrameDemo frameDemo = new FrameDemo();
        frameDemo.createAndShowGUI();
        frameDemo.showMessage("Hello!");
        frameDemo.showMessage("World!");
    }

}