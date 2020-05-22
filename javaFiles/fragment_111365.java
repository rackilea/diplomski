public class AFrame extends JFrame {
     private JButton jbt = new JButton("Open Window");
     private BFrame jfrm = new BFrame();

    public class AFrame(){
        add(jbt);
        jfrm.setVisibile(false);
        add(jfrm);

        jbt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jfrm.setVisibile(true);
            }
        });
    }
}


public class BFrame extends JFrame {

    public BFrame(){

   }

}