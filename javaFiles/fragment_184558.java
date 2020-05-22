import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class TspGui2 extends JPanel {
   private static final String ANNEALING_PROGRESS = "Annealing Progress";
   private JProgressBar progBar = new JProgressBar(0, 100);
   private JLabel valueLabel = new JLabel();
   private JButton beginAnnealingBtn = new JButton("Begin Annealing");
   private MyAnnealing myAnnealing = new MyAnnealing(this);

   public TspGui2() {
      beginAnnealingBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            beginAnnealing();
         }
      });
      myAnnealing.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(MyAnnealing.ANNEALING)) {
               // be sure this is done on the EDT
               SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                     int annealedValue = myAnnealing.getAnnealedValue();
                     setValue(annealedValue);
                     if (annealedValue >= MyAnnealing.MAX_ANNEALED_VALUE) {
                        beginAnnealingBtn.setEnabled(true);
                     }
                  }
               });
            }
         }
      });
      progBar.setString(ANNEALING_PROGRESS);
      progBar.setStringPainted(true);

      JPanel northPanel = new JPanel(new GridLayout(1, 0));
      northPanel.add(beginAnnealingBtn);
      northPanel.add(valueLabel);

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(northPanel);
      add(progBar);
   }

   public void setValue(int value) {
      valueLabel.setText("Value:" + value);
      progBar.setValue(value);
   }

   public void beginAnnealing() {
      beginAnnealingBtn.setEnabled(false);
      setValue(0);
      myAnnealing.reset();
      new Thread(new Runnable() {
         public void run() {
            myAnnealing.beginAnnealing();
         }
      }).start();
   }

   private static void createAndShowGui() {
      TspGui2 mainPanel = new TspGui2();

      JFrame frame = new JFrame("TspGui2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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

class MyAnnealing {
   public static final String ANNEALING = "Annealing";
   public  static final int MAX_ANNEALED_VALUE = 100;
   private SwingPropertyChangeSupport propChangeSupport = 
         new SwingPropertyChangeSupport(this);
   private TspGui2 gui;
   private int annealedValue;

   public MyAnnealing(TspGui2 gui) {
      this.gui = gui;
   }

   public void addPropertyChangeListener(
         PropertyChangeListener listener) {
      propChangeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(
         PropertyChangeListener listener) {
      propChangeSupport.removePropertyChangeListener(listener);
   }

   public void reset() {
      setAnnealedValue(0);
   }

   // simulate some long process...
   public void beginAnnealing() {
      long sleepDelay = 100;
      while (annealedValue < MAX_ANNEALED_VALUE) {
         setAnnealedValue(annealedValue + 1);
         try {
            Thread.sleep(sleepDelay);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public int getAnnealedValue() {
      return annealedValue;
   }

   private void setAnnealedValue(int value) {
      final int oldValue = this.annealedValue;
      this.annealedValue = value;
      propChangeSupport.firePropertyChange(ANNEALING, oldValue, annealedValue);
   }   
}