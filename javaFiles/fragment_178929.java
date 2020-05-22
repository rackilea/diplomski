public void showColoredMessageDialog(String message, Color color){
        //The label to show your message
        JLabel l = new JLabel(message);
        //the color for your message
        l.setForeground(color);
        //show JOptionPane.showMessageDialog with your custom color message
        JOptionPane.showMessageDialog(this, l);
    }

//You can call this method like for ex:
String msg = "hello world!";
//display this message with red color
showColoredMessageDialog(msg, Color.red);

//or you can also pass messages with variable values

int count = 10;
String msg2 = "the value of count is : " + count;

//display this message but this time with green color
showColoredMessageDialog(msg2, Color.green);