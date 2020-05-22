public class test {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      public void run() {
        JFrame j = new JFrame("Test");
        WorkBench right = new WorkBench();

        final JScrollPane sp = new JScrollPane(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        sp.setAutoscrolls(false);
        sp.setViewportView(right);

        j.getContentPane().add(sp, BorderLayout.CENTER);

        right.addPortal(getNewPortalPane());
        right.addPortal(getNewPortalPane());

        SwingUtilities.invokeLater(new Runnable() {

          public void run() {
            sp.getViewport().setViewPosition(new java.awt.Point(0, 0));
          }
        });

        // center the jframe, then make it visible
        j.setSize(800, 600);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      }
    });
  }

  public static JPanel getNewPortalPane() {
    JEditorPane html_box = new JEditorPane();
    html_box.setEditorKit(new HTMLEditorKit());
    html_box.setOpaque(true);
    html_box.setBackground(Color.WHITE);

    html_box.setContentType("text/html");

    String htmlString = "<html>\n"
        + "<body>\n"
        + "<h1>Welcomfve!  sdsdsdsdsd sdsdsd sdsd sdsd sdsd </h1>\n"
        + "<h2>This is an H2 header. sdsdsdsdsd sdsdsd sdsd sdsd sdsd </h2>\n"
        + "<p>This is some sample text  sdsdsdsdsd sdsdsd sdsd sdsd sdsd </p>\n"
        + "<p><a href=\"http://dsfsdfdf.com/blog/\">sdfsdfsdf blog</a></p>\n"
        + "</body>\n";

    html_box.setText(htmlString);

    JPanel p = new JPanel(new BorderLayout());
    p.setBackground(Color.blue);
    p.add(html_box, BorderLayout.NORTH);

    return p;
  }

  public static class WorkBench extends JPanel implements Scrollable {

    private final JPanel inner;

    public WorkBench() {
      setLayout(new BorderLayout());
      inner = new JPanel();
      inner.setLayout(new BoxLayout(inner, BoxLayout.PAGE_AXIS));
      add(inner, BorderLayout.NORTH);
    }

    public void addPortal(JPanel portal) {
      inner.add(portal);
      validate();
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
      return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
        int orientation, int direction) {
      return 20;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
        int orientation, int direction) {
      return 60;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
      return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
      if (getParent() instanceof JViewport) {
        return (((JViewport) getParent()).getHeight() > getPreferredSize().height);
      }

      return false;
    }
  }
}