import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class SwapText extends JPanel {
   private static final int ROWS = 25;
   private static final int COLS = 40;
   private static final String ABE_LINCOLN = "Abraham Lincoln's Gettysburg Address";
   private static final String CHIEF_JOSEPH = "Chief Joseph's Surrender Speech";
   private static final Font TXT_AREA_FONT = new Font("Serif", Font.PLAIN, 18);
   private JTextArea textArea = new JTextArea(ROWS, COLS);
   private Map<String, String> optionTextMap = new HashMap<>();

   public SwapText() {
      // add text to Map
      optionTextMap.put(ABE_LINCOLN,
                  "Four score and seven years ago our fathers brought forth, "
                        + "upon this continent, a new nation, conceived in Liberty, and "
                        + "dedicated to the proposition that all men are created"
                        + " equal.\n\n"
                        +

                        "Now we are engaged in a great civil war, testing whether "
                        + "that nation, or any nation so conceived, and so dedicated, "
                        + "can long endure. "
                        + "We are met here on a great battlefield of that war. "
                        + "We have come to dedicate a portion of it, as a final resting place for those who "
                        + "here gave their lives that that nation might live. "
                        + "It is altogether fitting and proper that we should do this.\n\n"
                        +

                        "But in a larger sense, we can not dedicate — we can not "
                        + "consecrate — we can not hallow — this ground. The brave men, living and dead, "
                        + "who struggled here, have consecrated it far above our "
                        + "poor power to add or detract. The world will little note, nor long remember, "
                        + "what we say here, but can never forget what they did here.\n\n"
                        +

                        "It is for us, the living, rather to be dedicated here "
                        + "to the unfinished work which they have, thus far, so nobly carried on. It is "
                        + "rather for us to be here dedicated to the great task "
                        + "remaining before us — that from these honored dead we take increased devotion "
                        + "to that cause for which they gave the last full measure of "
                        + "devotion – that we here highly resolve that these dead shall not have died in "
                        + "vain; that this nation shall have a new birth of freedom; "
                        + "and that this government of the people, by the people, for the people, "
                        + "shall not perish from the earth.");
      optionTextMap.put(CHIEF_JOSEPH,
                  "I am tired of fighting.  Our chiefs are killed.  Looking Glass is dead.  Toohulhulsote is dead.  "
                        + "The old men are all dead.  It is the young men who say yes or no. He who led the young men is dead.\n\n"
                        + "It is cold and we have no blankets.  The little children are freezing to death.  "
                        + "My people, some of them, have run away to the hills and have no blankets, "
                        + "no food.  No one knows where they are--perhaps freezing to death.  "
                        + "I want to have time to look for my children and see how many I can find.  "
                        + "Maybe I shall find them among the dead. \n\n"
                        + "Hear me, my chiefs.  I am tired.  My heart is sick and sad.  "
                        + "From where the sun now stands, I will fight no more forever.");

      // allow text area to wrap lines automatically
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setFocusable(false); // so folks can't edit text
      textArea.setFont(TXT_AREA_FONT);

      // place text area in a JScrollPane
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane
            .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      buttonPanel.add(new JButton(new OptionAction(ABE_LINCOLN)));
      buttonPanel.add(new JButton(new OptionAction(CHIEF_JOSEPH)));

      // use a BorderLayout for the main JPanel and add components
      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   private class OptionAction extends AbstractAction {
      public OptionAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         textArea.setText(optionTextMap.get(getValue(NAME)));
      }
   }

   private static void createAndShowGui() {
      SwapText mainPanel = new SwapText();

      JFrame frame = new JFrame("Swap Text");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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