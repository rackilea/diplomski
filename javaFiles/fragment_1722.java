public class SimpleEditor extends JFrame {

      public static void main(String[] args) {
      JFrame window = new SimpleEditor();
      window.setVisible(true);
      }
      private JEditorPane editPane;   

      public SimpleEditor() {
      editPane = new JEditorPane("text/rtf","");
      JScrollPane scroller = new JScrollPane(editPane);
      setContentPane(scroller);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      setSize(600,500);

      JMenu editMenu = new JMenu("Edit");

      Action cutAction = new DefaultEditorKit.CutAction();
      cutAction.putValue(Action.NAME, "Cut");
      editMenu.add(cutAction);

      Action copyAction = new DefaultEditorKit.CopyAction();
      copyAction.putValue(Action.NAME, "Copy");
      editMenu.add(copyAction);

      Action pasteAction = new DefaultEditorKit.PasteAction();
      pasteAction.putValue(Action.NAME, "Paste");
      editMenu.add(pasteAction);

      bar.add(editMenu);
   }

}