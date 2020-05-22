import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class MvcEg {

   private static void createAndShowGui() {
      View view = new MvcEgView();
      Model model = new MvcEgModel();
      new MvcEgControl(model, view);

      JFrame frame = new JFrame("MvcEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(view.getMainPanel());
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

interface View {

   void setMyButtonAction(Action action);

   Component getMainPanel();

   void setStatusLabelText(String text);

}

@SuppressWarnings("serial")
class MvcEgView implements View {
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;
   private static final String STATUS_TEXT = "Status: ";
   private JPanel mainPanel = new JPanel() {
      @Override
      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }
   };
   private JLabel statusLabel = new JLabel(STATUS_TEXT, SwingConstants.CENTER);
   private JButton myButton = new JButton();

   public MvcEgView() {
      JPanel btnPanel = new JPanel(new GridBagLayout());
      btnPanel.add(myButton);

      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(btnPanel, BorderLayout.CENTER);
      mainPanel.add(statusLabel, BorderLayout.SOUTH);
   }

   @Override
   public void setMyButtonAction(Action action) {
      myButton.setAction(action);
   }

   @Override
   public void setStatusLabelText(String text) {
      statusLabel.setText(STATUS_TEXT + text);
   }

   @Override
   public Component getMainPanel() {
      return mainPanel;
   }
}

interface Model {
   public static final String MOD_FIVE_STATUS = "mod five status";

   void incrementStatus();

   ModFiveStatus getModFiveStatus();

   void removePropertyChangeListener(PropertyChangeListener listener);

   void addPropertyChangeListener(PropertyChangeListener listener);

   void setModFiveStatus(ModFiveStatus modFiveStatus);

}

class MvcEgModel implements Model {
   private ModFiveStatus modFiveStatus = ModFiveStatus.ZERO;   
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);

   @Override
   public void incrementStatus() {
      int value = modFiveStatus.getValue();
      value++;
      value %= ModFiveStatus.values().length;
      setModFiveStatus(ModFiveStatus.getValuesStatus(value));
   }

   @Override
   public void setModFiveStatus(ModFiveStatus modFiveStatus) {
      ModFiveStatus oldValue = this.modFiveStatus;
      ModFiveStatus newValue = modFiveStatus;
      this.modFiveStatus = modFiveStatus;
      pcSupport.firePropertyChange(MOD_FIVE_STATUS, oldValue, newValue);
   }

   @Override
   public ModFiveStatus getModFiveStatus() {
      return modFiveStatus;
   }

   @Override
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   @Override
   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

}

enum ModFiveStatus {
   ZERO(0, "Zero"), ONE(1, "One"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four");
   private int value;
   private String text;

   private ModFiveStatus(int value, String text) {
      this.value = value;
      this.text = text;
   }

   public int getValue() {
      return value;
   }

   public String getText() {
      return text;
   }

   public static ModFiveStatus getValuesStatus(int value) {
      if (value < 0 || value >= values().length) {
         throw new ArrayIndexOutOfBoundsException(value);
      }

      for (ModFiveStatus modFiveStatus : ModFiveStatus.values()) {
         if (modFiveStatus.getValue() == value) {
            return modFiveStatus;
         }
      }
      // default that should never happen
      return null;
   }

}

@SuppressWarnings("serial")
class MvcEgControl {
   private Model model;
   private View view;

   public MvcEgControl(final Model model, final View view) {
      this.model = model;
      this.view = view;

      view.setMyButtonAction(new MyButtonAction("My Button", KeyEvent.VK_B));
      view.setStatusLabelText(model.getModFiveStatus().getText());
      System.out.println("model's status: " + model.getModFiveStatus());
      System.out.println("model's status text: " + model.getModFiveStatus().getText());

      model.addPropertyChangeListener(new ModelListener());
   }

   private class MyButtonAction extends AbstractAction {


      public MyButtonAction(String text, int mnemonic) {
         super(text);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         model.incrementStatus();
         System.out.println("button pressed");
      }
   }

   private class ModelListener implements PropertyChangeListener {

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getPropertyName().equals(Model.MOD_FIVE_STATUS)) {
            String status = model.getModFiveStatus().getText();
            view.setStatusLabelText(status);
            System.out.println("status is: " + status);
         }
      }

   }

}