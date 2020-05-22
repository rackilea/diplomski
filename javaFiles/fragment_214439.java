import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    enum Player {
        ONE, TWO;
    }

    public interface SixNumbersModel {

        public Player getCurrentTurn();

        public Player nextTurn();

        public int roll();

        public boolean hasWon(Player player);

        public Set<Integer> getPlayerResults(Player player);

        public int getTurnsCount(Player player);

        public void addChangeListener(ChangeListener listener);

        public void removeChangeListener(ChangeListener listener);
    }

    public class DefaultSizeNumbersModel implements SixNumbersModel {

        private List<ChangeListener> changeListeners;
        private Die die = new Die();

        private Player turn;

        private Map<Player, Set<Integer>> results;
        private Map<Player, Integer> turns;

        public DefaultSizeNumbersModel() {
            changeListeners = new ArrayList<>(2);
            results = new HashMap<>();
            results.put(Player.ONE, new HashSet<>(6));
            results.put(Player.TWO, new HashSet<>(6));
            turns = new HashMap<>(2);
            turns.put(Player.ONE, 0);
            turns.put(Player.TWO, 0);
            setCurrentTurn(Player.ONE);
        }

        @Override
        public Player getCurrentTurn() {
            return turn;
        }

        protected void setCurrentTurn(Player player) {
            turn = player;
        }

        @Override
        public Player nextTurn() {
            switch (getCurrentTurn()) {
                case ONE:
                    setCurrentTurn(Player.TWO);
                    break;
                case TWO:
                    setCurrentTurn(Player.ONE);
                    break;
                default:
                    setCurrentTurn(Player.ONE);
                    break;
            }
            fireStateChanged();
            return getCurrentTurn();
        }

        @Override
        public int roll() {
            incrementTurnCount(getCurrentTurn());
            int result = die.Roll();
            Set<Integer> playerResults = results.get(getCurrentTurn());
            playerResults.add(result);
            return result;
        }

        @Override
        public boolean hasWon(Player player) {
            Set<Integer> playerResults = results.get(getCurrentTurn());
            return playerResults.size() == 5; // 0...5
        }

        @Override
        public Set<Integer> getPlayerResults(Player player) {
            Set<Integer> actualResults = results.get(player);
            Set<Integer> copy = new HashSet<>(actualResults);
            return copy;
        }

        @Override
        public int getTurnsCount(Player player) {
            return turns.get(player);
        }

        protected void setTurnsCount(Player player, int count) {
            turns.put(player, count);
        }

        protected void incrementTurnCount(Player player) {
            int count = getTurnsCount(player);
            count++;
            setTurnsCount(player, count);
        }

        @Override
        public void addChangeListener(ChangeListener listener) {
            changeListeners.add(listener);
        }

        @Override
        public void removeChangeListener(ChangeListener listener) {
            changeListeners.remove(listener);
        }

        protected void fireStateChanged() {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : changeListeners) {
                listener.stateChanged(evt);
            }
        }
    }

    public class Die {

        private final int MAX = 6;
        private int die1;
        Random rand = new Random();

        //Constructor
        public Die() {
            die1 = 1;
        }// end Constructor

        public int Roll() {
            die1 = rand.nextInt(MAX) + 1;
            return die1;
        }
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Roll Six");
                frame.setLayout(new GridLayout(2, 0));

                SixNumbersModel model = new DefaultSizeNumbersModel();
                SixNumbersPanel onePane = new SixNumbersPanel(Player.ONE, model);
                SixNumbersPanel twoPane = new SixNumbersPanel(Player.TWO, model);

                frame.add(onePane);
                frame.add(twoPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SixNumbersPanel extends JPanel {

        private Player player;
        private SixNumbersModel model;

        private JButton roll;
        private JTextArea ta;

        public SixNumbersPanel(Player player, SixNumbersModel model) {
            this.player = player;
            this.model = model;

            model.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    roll.setEnabled(player == model.getCurrentTurn());
                }
            });

            roll = new JButton("Roll");
            ta = new JTextArea(5, 10);

            roll.setEnabled(player == model.getCurrentTurn());

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JLabel(player.name()), gbc);
            add(roll, gbc);

            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(ta), gbc);

            roll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = model.roll();
                    ta.append(Integer.toString(result) + "\n");
                    if (model.hasWon(player)) {
                        JOptionPane.showMessageDialog(SixNumbersPanel.this, player + " has won");
                    }
                    model.nextTurn();
                }
            });

        }

    }

}