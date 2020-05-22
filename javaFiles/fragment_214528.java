// imports...    
public class MyClass {

    private JButton[] buttons = new JButton[10];

    public MyClass() {
        // constructor

        for (int i = 0; i < this.buttons.length; i++) {
            final int myFinalIndex = i;
            this.buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MyClass.this.myMethod(myFinalIndex);
                }
            });
        }
    }

    public void myMethod(int id) {
        // perform actions
        // ...
    }

}