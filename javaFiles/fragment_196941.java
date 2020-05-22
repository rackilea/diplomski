private JLabel counter;
private JButton val5;
private JButton val10;
private JButton val25;
private JButton val50;

// a JLabel can only hold Strings, so you loose the int value. Therefore 
// you could hold the value in a separate variable and just update the label
// when you have a new value.
private int sum;   

public GUI() {
    super("The Title");
    setLayout(new FlowLayout());
    sum=0;                         // first we start at 0

    counter = new JLabel("This is the counter: 0");
    val5 = new JButton("5");
    val5.setActionCommand("5");
    val10 = new JButton("10");
    val10.setActionCommand("10");
    val25 = new JButton("25");
    val25.setActionCommand("25");
    val50 = new JButton("50");
    val50.setActionCommand("50");
    add(counter);
    add(val5);
    add(val10);
    add(val25);
    add(val50);

    HandlerClass handler = new HandlerClass();
    val5.addActionListener(handler);
    val10.addActionListener(handler);
    val25.addActionListener(handler);
    val50.addActionListener(handler);
}


class HandlerClass implements ActionListener {      
    // you may even hold the sum variable here, but this class is supposed to be a listener, not a model for your view. 

    public void actionPerformed(ActionEvent event) {

        if (GUI.this.sum < 1000) {    // your previous while loop was infinite. 
        // I don't know if you wanted to count to 1000 once the user clicks a button or just add the number. Anyway. 
        // GUI.this.sum will access the sum variable in the current GUI instance and then we check if the sum is smaller 1000. If so, we add the input value
            String action = event.getActionCommand();
            int numberInt = Integer.parseInt(action);
            // the switch is actually not necessary unless you plan to do more with it
            switch (numberInt) {
                case 5:
                    System.out.println("add 5");
                    break;
                case 10:
                    System.out.println("add 10");
                    break;
                case 25:
                    System.out.println("add 25");
                    break;
                default:
                    System.out.println("add 50");
                    break;
                //counter.setText(String.valueOf(action));
            }
            sum+=numberInt; // first we add the value from the button to the global sum
            counter.setText("This is the counter: "+sum); //then we update the text from the label with the new value
        }
    }
}