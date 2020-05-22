public class Gui {

    private int counter;

    // This creates a frame or panel to contain things
    public static void main(String[] args) {

        Gui gui = new Gui();
        gui.create();
    }

    private void create() {

        // Creating The Frame
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.getContentPane().add(panel);

        // Creating The Label
        JLabel label3 = new JLabel("Counter: ");
        panel.add(label3);

        // Button Which should have a funtion to add and display the number
        JButton button = new JButton("Click Here.");
        panel.add(button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(counter++);
            }
        });

        // Button to reset the counter
        JButton buttonReset = new JButton("Reset Counter.");
        panel.add(buttonReset);

        buttonReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
            }
        });

        // Set Size Of Window
        frame.setSize(new Dimension(500, 400));
        // Set Starting Position to centre
        frame.setLocationRelativeTo(null);
        // Setting a default close action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set Title
        frame.setTitle("Counter");
        // Disable Resize
        frame.setResizable(false);
        // Setting if its visible
        frame.setVisible(true);
        // Fits frame to fit everything
      }
  }