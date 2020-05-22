public class GUI extends JFrame implements ActionListener {
   ...//some global variables
  public GUI ()
  {
    super("Closest Word Automaton");
    this.setSize(1000, 640);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setLayout(new CardLayout());

    initArray();

    JTabbedPane tabs = new JTabbedPane();
    tabs.add("Edit View", createEditView());
    tabs.add("Automaton View", createAutomatonView());
    tabs.add("Levenshtein Distance Calculator", createLevCalculator());
    this.add(tabs);

    this.pack();
    this.setVisible(true);  //setVisible to true after adding components

    addListener();
  }