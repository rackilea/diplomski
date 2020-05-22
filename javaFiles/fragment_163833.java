import java.awt.BorderLayout; 
import java.text.ParseException; 

import javax.swing.JFormattedTextField; 
import javax.swing.JFrame; 
import javax.swing.JSpinner; 
import javax.swing.SpinnerNumberModel; 
import javax.swing.JFormattedTextField.AbstractFormatter; 
import javax.swing.text.DefaultFormatter; 
import javax.swing.text.DefaultFormatterFactory; 


public class HexSpinnerTest { 

  public static void main(String[] args) { 
     JFrame f = new JFrame(); 
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     JSpinner sp = new JSpinner(new SpinnerNumberModel(0,0,10000,1)); 
     JSpinner.DefaultEditor editor = 
     (JSpinner.DefaultEditor)sp.getEditor(); 
     JFormattedTextField tf = editor.getTextField(); 
     tf.setFormatterFactory(new MyFormatterFactory()); 
     f.getContentPane().add(sp, BorderLayout.NORTH); 
     f.setSize(200,200); 
     f.setVisible(true); 
  }

  private static class MyFormatterFactory extends DefaultFormatterFactory { 
        public AbstractFormatter getDefaultFormatter() { 
           return new HexFormatter(); 
       } 
  } 

  private static class HexFormatter extends DefaultFormatter { 
      public Object stringToValue(String text) throws ParseException { 
         try { 
            return Long.valueOf(text, 16); 
         } catch (NumberFormatException nfe) { 
            throw new ParseException(text,0); 
         } 
     } 

     public String valueToString(Object value) throws ParseException { 
           return Integer.toHexString( 
              ((Integer)value).intValue()).toUpperCase(); 
     } 
 } 
}