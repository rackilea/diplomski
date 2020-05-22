public class MyActionListener implements ActionListener {

    private String input;

    public MyActionListener(String input) {
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(input);
    }
}

public A2(){

    String[] inputs = {"Fing","Fang","Foom"};//Array of JButton inputs
    for(int i=0;i<inputs.length;i++) {
        JButton jButton = new JButton(inputs[i]);//create JButton instance
        jButton.addActionListener(new MyActionListener(inputs[i]));
    }
}