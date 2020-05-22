public class MyBox extends JComponent {
     Dimension boxSize;

     public void setBoxSize(Dimension box) {
         this.boxSize = new Dimension(box);
         ...   
     } 

     @Override
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         // position the box in the actual size
         // and paint it 
     }

     @Override
     public Dimension getPreferredSize() {
         return getBoxSize();
     }
     @Override // same for min/max
     public Dimension getM...Size( {
         return getBoxSize();
     }
}