public class Game extends JFrame implements ActionListener {

    Drawing object = new Drawing();
    Timer t = new Timer(1, this);
    int score;
    ArrayList<Enemy> bombs = new ArrayList<Enemy>();

    public Game() {
        t.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        add(object);
        add(new JLabel("Hello"));
        validate();
        createBombs();

        setVisible(true);
    }
}