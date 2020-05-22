/**
 * 1. this implements FocusListener is important
 * 2. another interfaces you had here before also should be present
 */
public class YourClass implements FocusListener {  

        public void makeUI(){
            text = new JTextField(defaultMessage);
            text.setBounds(10,620,295,40);
            text.addFocusListener(this);
            add(text);
            button = new JButton("SEND");
            button.setBounds(310,620,80,40);
            button.setForeground(Color.WHITE);
            button.setBackground(Color.decode("#11A458"));
            button.setFocusPainted(false);
            button.addActionListener(this);
            add(button);
            setSize(400,700);
            setLayout(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void focusGained(FocusEvent ae){
            if(text.getText().equals(defaultMessage)){
                text.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent ae){
            if(text.getText().isEmpty()){
                text.setText(defaultMessage);
            }
        }

}