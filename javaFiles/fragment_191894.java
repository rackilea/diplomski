public class SwingExample {

    private JLabel lblLabel;    
    private static SwingExample instance;    

    SwingExample() {
        // code omitted
    }

    public void setLabel() {
        lblLabel.setText("Bye Bye !!!");
    }

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new SwingExample();
            }
        });

        // ...

        EventQueue.invokeLater(new Runnable() {
            public void run() {
              instance.setLabel();
            }
        });
    }
}