public class PanelTitle implements ActionListener{
     String title;
    public PanelTitle(){
    }                     
    @Override
    public void actionPerformed(ActionEvent ae){
         SedimentPanel sp = new SedimentPanel(); // ********
         sp.titledBorder.setTitle("SEDIMENT");

         sp.repaint();
         sp.revalidate();
    }
}