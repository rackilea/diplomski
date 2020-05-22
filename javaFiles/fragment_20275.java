import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SOQ18 implements KeyListener
{

   public boolean o, shift;
   public JFrame f;
   public JLabel l;

   public SOQ18()
   {

      f = new JFrame();
      l = new JLabel();
      f.setSize(200,200);
      f.setLocation(200,200);
      f.add(l);
      l.setText("Testing testing, 123...");

      f.addKeyListener(this);

      f.setVisible(true);


   }

   /** Will translate and handle the keystrokes as they are pressed and released */
   private void keyTranslate(KeyEvent e, boolean b)
   {

      int keyCode = e.getKeyCode();

      if(KeyEvent.getKeyText(keyCode).equals("O"))
      {

         o = b;

      }

      if(KeyEvent.getKeyText(keyCode).equals("Shift"))
      {

         shift = b;

      }

      if(o && shift)
      {

      //do whatever code you wanted to do here, but in the meantime...
         l.setText("They have both been pressed!");

      }

      else
      {
         l.setText("Not yet...");
      }

   }

   /** Handle the key typed event */
   public void keyTyped(KeyEvent e) 
   {

      // do nothing

   }

   /** Handle the key pressed event */
   public void keyPressed(KeyEvent e) 
   {

      keyTranslate(e, true);

   }

   /** Handle the key released event */
   public void keyReleased(KeyEvent e) 
   {

      keyTranslate(e, false);

   }

   public static void main(String[] args)
   {

      SOQ18 soq = new SOQ18();

   }

}