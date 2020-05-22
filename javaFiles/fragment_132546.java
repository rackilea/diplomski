public class Main extends JFrame {
    private Main() {
        super();
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        Console console = new Console();
        Main launcher = new Main();
        launcher.setVisible(true);
        console.getFrame().setLocation(
                launcher.getX() + launcher.getWidth() + launcher.getInsets().right,
                launcher.getY());

        System.out.println("1- log");
        System.out.println("2- log");
        System.out.println("3- log");
        System.err.println("1- error");
        System.err.println("2- error");
    }
}

class Console {
    final JFrame frame = new JFrame();
    JTextArea textArea;

    public Console() throws Exception {
        textArea = new JTextArea(24, 80);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);

        redirectOut();

        System.out.println("Hello world!");
        System.out.println("test");
//        throw new Exception("excccccc");
    }

    public PrintStream redirectOut() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        };
        PrintStream ps = new PrintStream(out);

        System.setOut(ps);
        System.setErr(ps);

        return ps;
    }

    public JFrame getFrame() {
        return frame;
    }
}