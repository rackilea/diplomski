public class MainFrame extends JFrame {
  private JPanel panel;
  private JButton performance;
  private JButton concordance;
  private JButton discordance;
  private JButton resultat;

  public MainFrame() {
    super();
    MainFrame();
  }

  public void MainFrame() {
    panel = new JPanel(new GridLayout(4, 1, 10, 10));
    performance = new JButton("performance");
    concordance = new JButton("concordance");
    discordance = new JButton("discordance");
    resultat = new JButton("resultat");

    performance.setSize(50, 30);
    concordance.setSize(50, 30);
    discordance.setSize(50, 30);
    resultat.setSize(50, 30);

    panel.add(performance);
    panel.add(concordance);
    panel.add(discordance);
    panel.add(resultat);
    this.getContentPane().add(panel);

  }

  public static void main(String[] args) {
    MainFrame main = new MainFrame();
    main.setSize(300, 200);
    main.setDefaultCloseOperation(EXIT_ON_CLOSE);
    main.setVisible(true);
    main.MainFrame();
  }
}