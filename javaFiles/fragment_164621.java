class testDialog {

   public static void main(String[] args) {
      JDialog d = new JDialog();
      JDesktopPane desktoppane = new JDesktopPane(); // added
      desktoppane.setPreferredSize(new Dimension(100, 100));// added
      JInternalFrame i = new JInternalFrame("HI", false, false, false, false);
      // i.setPreferredSize(new Dimension(100, 100));
      i.setBounds(0, 0, 100, 100);// added
      desktoppane.add(i);
      i.setVisible(true);

      d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      d.setTitle("Wait dialog");
      // d.add(i);
      d.add(desktoppane); // added
      d.pack();
      // d.setPreferredSize(new Dimension(100, 100));
      d.setLocation(300, 300);
      d.setAlwaysOnTop(true);
      d.setVisible(true);
   }
}