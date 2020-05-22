import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class PropChangeEg {
   private static void createAndShowGui() {
      final JLabel counterLabel = new JLabel(" ", SwingConstants.CENTER);

      CustomComponent myCustomComponent = new CustomComponent();
      myCustomComponent.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (pcEvt.getPropertyName().equals(CustomComponent.COUNTER)) {
               String text = "Counter: " + pcEvt.getNewValue();
               counterLabel.setText(text);
            }
         }
      });

      JFrame frame = new JFrame("PropChangeEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(myCustomComponent, BorderLayout.CENTER);
      frame.add(counterLabel, BorderLayout.PAGE_END);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class CustomComponent extends JComponent {
   public static final String COUNTER = "counter";
   private int counter = 0;

   public CustomComponent() {
      setLayout(new FlowLayout());
      add(new JButton(new AbstractAction("Increment Counter") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            setCounter(counter + 1);
         }
      }));
      add(new JButton(new AbstractAction("Decrement Counter") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            setCounter(counter - 1);
         }
      }));
   }

   //@Override // not needed!!
   //public void addPropertyChangeListener(PropertyChangeListener listener) {
   //   super.addPropertyChangeListener(listener);
   //}

   //@Override // not needed!!
   //public void removePropertyChangeListener(PropertyChangeListener listener) {
   //   super.removePropertyChangeListener(listener);
   //}

   public void setCounter(int counter) {
      int oldValue = this.counter;
      int newValue = counter;
      this.counter = newValue;
      firePropertyChange(COUNTER, oldValue, newValue);
   }

   public int getCounter() {
      return counter;
   }


}