public class MyClass {

    // Notice the placement outside the main()    
    private static int counter = 0;

    public static void main(String[] args) {
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                startButton.doSomething()
                //do some more stuff

                counter++;

             }
           }
         );    
    }
}