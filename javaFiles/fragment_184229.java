import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonJava3 extends JButton
  implements ActionListener{

  public static final int noOfButtons = 3;
  private static final Color[] COLORS = { Color.ORANGE,
    Color.WHITE,
    Color.GREEN};
  private int clicks;
  private static boolean firstButtonClicked = false;
  private int colorIndex, index;
  private static ButtonJava3[] buttons;

  public static void main ( String[] args ) {
    JFrame frame = new JFrame ( "ButtonJava (the Hutt)" );
    JPanel panel = new JPanel( );
    buttons = new ButtonJava3[noOfButtons];
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    for(int i = 0;i < noOfButtons ; i++){
        buttons[i] = new ButtonJava3(i); // One button of each color
        panel.add(buttons[i]);
    }
    frame.getContentPane( ).add( panel );
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }

  private ButtonJava3(int index){
    this.index = index;
    setBackground( Color.YELLOW );
    setText( "Pick Me" );
    this.addActionListener( this );
  }

  private void updateButtons( ) {
    clicks++;
    for(int i = 0; i< noOfButtons; i++){
        buttons[i].updateButton(); // update each button
    }
    setText( Integer.toString(clicks) );
  }
  private final void updateButton(){
    colorIndex--;; // Go to the next color
    if(colorIndex < 0){ // if there is no next color
        colorIndex = noOfButtons-1; // go back to first color
     }// apply result
    setBackground(COLORS[colorIndex]);
   }
  private final void colorOther(){
      for(int i = 0; i < noOfButtons; i++){
          if(i != index){
              buttons[i].colorIndex = checkColor(colorIndex+(i-index));
          }
      }
  }

  private final static int checkColor(int i){
      if(i >= noOfButtons){
          i -= (noOfButtons);
      }else if(i < 0){
          i = (noOfButtons)+i;
      }
      return i;
  }
  @Override
  public void actionPerformed( ActionEvent event ){
      if(!firstButtonClicked){
        colorIndex = 1;
        colorOther();firstButtonClicked = true;
      }
    updateButtons( );
  }
}