public class JComboExample {

  private static JFrame frame = new JFrame();
  private static final String NOT_SELECTABLE_OPTION = " - Select an Option - ";
  private static final String NORMAL_OPTION = "Normal Option";

  public static void main(String[] args) throws Exception {
    JComboBox<String> comboBox = new JComboBox<String>();

    comboBox.setModel(new DefaultComboBoxModel<String>() {
      private static final long serialVersionUID = 1L;
      boolean selectionAllowed = true;

      @Override
      public void setSelectedItem(Object anObject) {
        if (!NOT_SELECTABLE_OPTION.equals(anObject)) {
          super.setSelectedItem(anObject);
        } else if (selectionAllowed) {
          // Allow this just once
          selectionAllowed = false;
          super.setSelectedItem(anObject);
        }
      }
    });

    comboBox.addItem(NOT_SELECTABLE_OPTION);
    comboBox.addItem(NORMAL_OPTION);

    frame.add(comboBox);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        frame.setVisible(true);
      }
    });
  }
}