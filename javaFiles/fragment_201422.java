public class Form implements ActionListener {

    private static int n;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame();
        JButton button = new JButton("Click Me!");
        button.addActionListener(new Form());
        JLabel label = new JLabel("DrawSquare");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel,BorderLayout.NORTH);

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter The Size Of Your Head!  Or Square.   Whichever!");
        n = user_input.nextInt();

        int FRAME_WIDTH = (n + 600);
        int FRAME_HEIGHT = (n + 400);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A nice "
                + n
                + " by "
                + n
                + " Square! Just click the button and watch the instantanious magic!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JPanel p = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int height = n;
                int width = n;
                g.setColor(Color.blue);
                g.drawRect(10, 10, height, width);
            };

        };
        frame.getContentPane().add(p,BorderLayout.CENTER);
        frame.getContentPane().revalidate();
    }
}