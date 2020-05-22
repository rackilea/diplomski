public class Link extends JFrame {
  public static void main(String[] args) {
    new Link();
  }

  public Link(){    
    JLabel link = new JLabel("<html><font color=\"#0000ff\"><u>The link</u></font></html>");
    link.setCursor(new Cursor(Cursor.HAND_CURSOR));
    link.addMouseListener(new MouseListener(){
      public void mouseClicked(MouseEvent e) {
        System.out.println("Link was clicked");
      }
      //other MouseListener methods 
    });

    add(link);
    pack();
    setVisible(true);       
  }
}