import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo {

    private void createAndShowGUI() {        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                GameField gameField = (GameField)button.getClientProperty("GameField");
                if(gameField != null) {
                    System.out.println(gameField.getText());
                }
            }
        };

        GameField gameField1 = new GameField("Button # 1");
        gameField1.getButton().addActionListener(actionListener);

        GameField gameField2 = new GameField("Button # 2");
        gameField2.getButton().addActionListener(actionListener);

        JPanel content = new JPanel(new GridLayout());
        content.add(gameField1.getButton());
        content.add(gameField2.getButton());

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class GameField {

        private String text;
        private JButton button;

        public GameField(String text) {
            this.text = text;
            button = new JButton(text);
            button.putClientProperty("GameField", GameField.this);
        }

        public JButton getButton() {
            return button;
        }

        public String getText() {
            return text;
        }        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                
                new Demo().createAndShowGUI();
            }
        });
    }    
}