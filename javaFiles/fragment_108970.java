public class ConstrainVisibility extends JPanel {

  protected static final String LS = System.getProperty("line.separator");
  protected static final int OFFSET_X = 150;
  protected static final int OFFSET_Y = 120;
  protected static final int WIDTH = 200;
  protected static final int HEIGHT = 200;

  public ConstrainVisibility() {
    super(new BorderLayout());
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setOpaque(true);
    layeredPane.setBackground(new Color(200, 200, 255));
    int layerIndex = 0;
    // A flash player

    // A swing panel
    JPanel swingPanel = new JPanel();
    swingPanel.setBorder(BorderFactory.createTitledBorder("Swing JPanel"));
    swingPanel.setBackground(Color.GREEN);
    swingPanel.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(swingPanel, layerIndex++);
    layeredPane.add(swingPanel);
    // A web browser
    JWebBrowser webBrowser = new JWebBrowser(JWebBrowser.constrainVisibility());
    webBrowser.setBarsVisible(false);
    webBrowser.setStatusBarVisible(true);
    webBrowser.setHTMLContent(
        "<html>" + LS +
        "  <body>" + LS +
        "    <h1>A web page</h1>" + LS +
        "    <p>A paragraph with a <a href=\"http://www.google.com\">link</a>.</p>" + LS +
        "  </body>" + LS +
        "</html>");
    webBrowser.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(webBrowser, layerIndex++);
    // A swing button
    JButton swingButton = new JButton("Swing JButton");
    swingButton.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(swingButton, layerIndex++);
    layeredPane.add(swingButton);
    layeredPane.add(webBrowser);
    layeredPane.setPreferredSize(new Dimension(WIDTH + OFFSET_X * (layerIndex - 1), HEIGHT + OFFSET_Y * (layerIndex - 1)));
    add(new JScrollPane(layeredPane), BorderLayout.CENTER);
  }

  /* Standard main method to try that test as a standalone application. */
  public static void main(String[] args) {
    UIUtils.setPreferredLookAndFeel();
    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("DJ Native Swing Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ConstrainVisibility(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      }
    });
    NativeInterface.runEventPump();
  }

}