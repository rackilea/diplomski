import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class DependInjectEg {
   private static void createAndShowGui() {
      Player[] players = {
            new Player("John Smith", 10, 5),
            new Player("Donald Duck", 8, 3),
            new Player("Doris Day", 5, 2),
            new Player("Bill Jones", 4, 6),
            new Player("Frank Stein", 1, 1),
      };

      PlayerStats mainPanel = new PlayerStats();
      for (Player player : players) {
         mainPanel.addPlayer(player);
      }

      JFrame frame = new JFrame("Dependency Injection Example");
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

class Player {
   private String name;
   private int speed;
   private int strength;

   // default constructor
   public Player() {
   }

   public Player(String name, int speed, int strength) {
      this.name = name;
      this.speed = speed;
      this.strength = strength;
   }

   public int getStrength() {
      return strength;
   }

   public void setStrength(int strength) {
      this.strength = strength;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getSpeed() {
      return speed;
   }

   public void setSpeed(int speed) {
      this.speed = speed;
   }

   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("Name: " + name + ", ");
      sb.append("Speed: " + speed + ", ");
      sb.append("Strength: " + strength);

      return sb.toString();
   }

}

@SuppressWarnings("serial")
class PlayerStats extends JPanel {
   private DefaultListModel playerListModel = new DefaultListModel();
   private JList playerList = new JList(playerListModel);

   public PlayerStats() {
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      btnPanel.add(new JButton(new NewPlayerAction()));
      btnPanel.add(new JButton(new EditPlayerAction()));
      btnPanel.add(new JButton(new ExitAction()));

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Player Stats"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      add(new JScrollPane(playerList));
      add(Box.createVerticalStrut(5));
      add(btnPanel);

   }

   public void addPlayer(Player player) {
      playerListModel.addElement(player);
   }

   private class NewPlayerAction extends AbstractAction {
      public NewPlayerAction() {
         super("New Player");
         putValue(MNEMONIC_KEY, KeyEvent.VK_N);
      }

      public void actionPerformed(ActionEvent evt) {
         PlayerEditorPanel editorPanel = new PlayerEditorPanel();
         int result = JOptionPane.showConfirmDialog(PlayerStats.this,
               editorPanel, "Create Player", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {
            Player player = editorPanel.getNewPlayer();
            playerListModel.addElement(player);
         }
      };
   }

   private class EditPlayerAction extends AbstractAction {
      public EditPlayerAction() {
         super("Edit Player");
         putValue(MNEMONIC_KEY, KeyEvent.VK_E);
      }

      public void actionPerformed(ActionEvent evt) {
         Player player = (Player) playerList.getSelectedValue();
         if (player == null) {
            return; // do nothing if no player selected
         }
         PlayerEditorPanel editorPanel = new PlayerEditorPanel();
         editorPanel.setPlayer(player);

         int result = JOptionPane.showConfirmDialog(PlayerStats.this,
               editorPanel, "Edit Player", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {
            editorPanel.upDatePlayerAttributes();
            playerList.repaint();
         }
      }
   }

   private class ExitAction extends AbstractAction {
      public ExitAction() {
         super("Exit");
         putValue(MNEMONIC_KEY, KeyEvent.VK_X);
      }

      public void actionPerformed(ActionEvent e) {
         Window win = SwingUtilities.getWindowAncestor(PlayerStats.this);
         win.dispose();
      }

   }
}

@SuppressWarnings("serial")
class PlayerEditorPanel extends JPanel {
   public static final String[] FIELD_TITLES = { "Name", "Speed", "Strength" };
   private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
   private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
   private JTextField nameField = new JTextField(10);
   private JTextField speedField = new JTextField(10);
   private JTextField strengthField = new JTextField(10);
   private JTextField[] fields = { nameField, speedField, strengthField };
   private Player player;

   public PlayerEditorPanel() {
      setLayout(new GridBagLayout());
      setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Player Editor"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      GridBagConstraints gbc;
      for (int i = 0; i < FIELD_TITLES.length; i++) {
         gbc = createGbc(0, i);
         add(new JLabel(FIELD_TITLES[i] + ":", JLabel.LEFT), gbc);
         gbc = createGbc(1, i);
         add(fields[i], gbc);
      }
   }

   @SuppressWarnings("static-access")
   private GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;

      // bad coding habit using variable name to access static constants
      // done for sake of brevity and clarity
      gbc.anchor = (x == 0) ? gbc.WEST : gbc.EAST;
      gbc.fill = (x == 0) ? gbc.BOTH : gbc.HORIZONTAL;

      gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
      gbc.weightx = (x == 0) ? 0.1 : 1.0;
      gbc.weighty = 1.0;
      return gbc;
   }

   public void setPlayer(Player player) {
      this.player = player;
      nameField.setText(player.getName());
      speedField.setText(String.valueOf(player.getSpeed()));
      strengthField.setText(String.valueOf(player.getStrength()));
   }

   public Player getNewPlayer() {
      String name = nameField.getText();
      int strength = 0;
      try {
         strength = Integer.parseInt(strengthField.getText());
      } catch (NumberFormatException e) {
         // TODO: notify user that field was empty
      }
      int speed = 0;
      try {
         speed = Integer.parseInt(speedField.getText());
      } catch (NumberFormatException e) {
         // TODO: notify user that field was empty
      }

      Player p = new Player();
      p.setName(name);
      p.setSpeed(speed);
      p.setStrength(strength);

      return p;
   }

   public void upDatePlayerAttributes() {
      String name = nameField.getText();
      int strength = 0;
      try {
         strength = Integer.parseInt(strengthField.getText());
      } catch (NumberFormatException e) {
         // TODO: notify user that field was empty
      }
      int speed = 0;
      try {
         speed = Integer.parseInt(speedField.getText());
      } catch (NumberFormatException e) {
         // TODO: notify user that field was empty
      }

      player.setName(name);
      player.setSpeed(speed);
      player.setStrength(strength);
   }
}