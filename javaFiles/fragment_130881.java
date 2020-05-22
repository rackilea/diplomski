import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ProgState extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final Color EDIT_COLOR = Color.red;
   private EditMode editMode = EditMode.NONE;
   private boolean firstPointSelected = false;
   private JMenuBar jMenuBar = new JMenuBar();
   private JTextField firstPointField = new JTextField(15);
   private JTextField secondPointField = new JTextField(15);

   public ProgState() {
      add(firstPointField);
      add(secondPointField);

      JMenu menu = new JMenu("Menu");
      menu.add(new JMenuItem(new AbstractAction("Edit") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            setEditMode(EditMode.EDITING);
            setFirstPointSelected(false);
         }
      }));
      jMenuBar.add(menu);

      addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent mEvt) {
            if (getEditMode() == EditMode.EDITING) {
               Point p = mEvt.getPoint();
               String pStr = String.format("[%d, %d]", p.x, p.y);
               if (!isFirstPointSelected()) {
                  firstPointField.setText(pStr);
                  setFirstPointSelected(true);
               } else {
                  secondPointField.setText(pStr);
                  setEditMode(EditMode.NONE);
               }
            }
         }

      });
   }

   public void setEditMode(EditMode editMode) {
      this.editMode = editMode;

      Color c = editMode == EditMode.NONE ? null : EDIT_COLOR;
      setBackground(c);
   }

   public EditMode getEditMode() {
      return editMode;
   }

   public void setFirstPointSelected(boolean firstPointSelected) {
      this.firstPointSelected = firstPointSelected;
   }

   public boolean isFirstPointSelected() {
      return firstPointSelected;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public JMenuBar getJMenuBar() {
      return jMenuBar;
   }

   private static void createAndShowGui() {
      ProgState progState = new ProgState();

      JFrame frame = new JFrame("EditMode");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(progState);
      frame.setJMenuBar(progState.getJMenuBar());
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

enum EditMode {
   NONE, EDITING
}