import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SlideButtons extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 200;
   private static final int MAX_BUTTONS = 100;
   private static final int SCROLL_TIMER_DELAY = 10;
   public static final int SCROLL_DELTA = 3;
   private JPanel btnPanel = new JPanel(new GridLayout(1, 0, 10, 0));
   private JScrollPane scrollPane = new JScrollPane(btnPanel);
   private JButton scrollLeftBtn = new JButton("<");
   private JButton scrollRightBtn = new JButton(">");
   private BoundedRangeModel horizontalModel = scrollPane.getHorizontalScrollBar().getModel();
   private Timer scrollTimer = new Timer(SCROLL_TIMER_DELAY, new ScrollTimerListener());
   public String btnText = "";

   public SlideButtons() {
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
      for (int i = 0; i < MAX_BUTTONS; i++) {
         String text = String.format("Button %03d", (i + 1));
         JButton btn = new JButton(text);
         btnPanel.add(btn);
      }
      ScrollingBtnListener scrollingBtnListener = new ScrollingBtnListener();
      scrollLeftBtn.addChangeListener(scrollingBtnListener);
      scrollRightBtn.addChangeListener(scrollingBtnListener);

      JPanel northPanel = new JPanel(new BorderLayout());
      northPanel.add(scrollLeftBtn, BorderLayout.LINE_START);
      northPanel.add(scrollPane, BorderLayout.CENTER);
      northPanel.add(scrollRightBtn, BorderLayout.LINE_END);

      setLayout(new BorderLayout());
      add(northPanel, BorderLayout.PAGE_START);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class ScrollingBtnListener implements ChangeListener {
      @Override
      public void stateChanged(ChangeEvent e) {
         JButton btn = (JButton)e.getSource();
         ButtonModel model = btn.getModel();
         //actionCommand  = model.getActionCommand();
         btnText = btn.getText();
         if (model.isPressed() && model.isEnabled()) {
            scrollTimer.start();
         } else {
            scrollTimer.stop();
         }
      }
   }

   private class ScrollTimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (btnText == null) {
            return;
         }
         int max = horizontalModel.getMaximum();
         int min = horizontalModel.getMinimum();
         int value = horizontalModel.getValue();

         if (btnText.equals(">")) {
            if (value <= max) {
               value += SCROLL_DELTA;
            } else {
               value = max;
            }
         } else if (btnText.equals("<")) {
            if (value >= min) {
               value -= SCROLL_DELTA;
            } else {
               value = min;
            }
         }
         horizontalModel.setValue(value);
      }
   }

   private static void createAndShowGui() {
      SlideButtons mainPanel = new SlideButtons();

      JFrame frame = new JFrame("SlideButtons");
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