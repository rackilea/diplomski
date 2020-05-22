public class UIPanel extends JPanel {
  private static final String BLANK_CARD = "blank";
  private final JSplitPane splitPane;

  public UIPanel() {
    super(new BorderLayout());

    JPanel treePnl = createTreePanel();
    JPanel contextPnl = createContextPanel();

    this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
      true, new JScrollPane(treePnl), new JScrollPane(contextPnl));

    add(splitPane, BorderLayout.CENTER);
  }
}