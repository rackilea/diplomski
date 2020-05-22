import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MineSweeper {
    private JPanel mainPanel = new JPanel();
    private MineCellGrid mineCellGrid;
    private JButton resetButton = new JButton("Reset");

    public MineSweeper(int rows, int cols, int mineTotal) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mineCellGrid = new MineCellGrid(rows, cols, mineTotal);

        resetButton.setMnemonic(KeyEvent.VK_R);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mineCellGrid.reset();
            }
        });

        mainPanel.add(mineCellGrid);
        mainPanel.add(new JSeparator());
        mainPanel.add(new JPanel() {
            {
                add(resetButton);
            }
        });
    }

    private JPanel getMainPanel() {
        return mainPanel;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("MineSweeper");
        // frame.getContentPane().add(new MineSweeper(20, 20,
        // 44).getMainPanel());
        frame.getContentPane().add(new MineSweeper(12, 12, 13).getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}

@SuppressWarnings("serial")
class MineCellGrid extends JPanel {
    private MineCellGridModel model;
    private List<MineCell> mineCells = new ArrayList<>();

    public MineCellGrid(final int maxRows, final int maxCols, int mineNumber) {
        model = new MineCellGridModel(maxRows, maxCols, mineNumber);
        setLayout(new GridLayout(maxRows, maxCols));

        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                MineCell mineCell = new MineCell(row, col);
                add(mineCell);
                mineCells.add(mineCell);
                model.add(mineCell.getModel(), row, col);
            }
        }

        reset();
    }

    public void reset() {
        model.reset();
        for (MineCell mineCell : mineCells) {
            mineCell.reset();
        }
    }
}

class MineCellGridModel {
    private MineCellModel[][] cellModelGrid;
    private List<Boolean> mineList = new ArrayList<Boolean>();
    private CellModelPropertyChangeListener cellModelPropChangeListener = new CellModelPropertyChangeListener();
    private int maxRows;
    private int maxCols;
    private int mineNumber;
    private int buttonsRemaining;

    public MineCellGridModel(final int maxRows, final int maxCols, int mineNumber) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.mineNumber = mineNumber;
        for (int i = 0; i < maxRows * maxCols; i++) {
            mineList.add((i < mineNumber) ? true : false);
        }
        cellModelGrid = new MineCellModel[maxRows][maxCols];
        buttonsRemaining = (maxRows * maxCols) - mineNumber;
    }

    public void add(MineCellModel model, int row, int col) {
        cellModelGrid[row][col] = model;
        model.addPropertyChangeListener(cellModelPropChangeListener);
    }

    public void reset() {
        buttonsRemaining = (maxRows * maxCols) - mineNumber;

        // randomize the mine location
        Collections.shuffle(mineList);
        // reset the model grid and set mines
        for (int r = 0; r < cellModelGrid.length; r++) {
            for (int c = 0; c < cellModelGrid[r].length; c++) {
                cellModelGrid[r][c].reset();
                cellModelGrid[r][c].setMined(mineList.get(r * cellModelGrid[r].length + c));
            }
        }
        // advance value property of all neighbors of a mined cell
        for (int r = 0; r < cellModelGrid.length; r++) {
            for (int c = 0; c < cellModelGrid[r].length; c++) {
                if (cellModelGrid[r][c].isMined()) {
                    int rMin = Math.max(r - 1, 0);
                    int cMin = Math.max(c - 1, 0);
                    int rMax = Math.min(r + 1, cellModelGrid.length - 1);
                    int cMax = Math.min(c + 1, cellModelGrid[r].length - 1);
                    for (int row2 = rMin; row2 <= rMax; row2++) {
                        for (int col2 = cMin; col2 <= cMax; col2++) {
                            cellModelGrid[row2][col2].incrementValue();
                        }
                    }
                }
            }
        }
    }

    private class CellModelPropertyChangeListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {
            MineCellModel model = (MineCellModel) evt.getSource();
            int row = model.getRow();
            int col = model.getCol();

            if (evt.getPropertyName().equals(MineCellModel.BUTTON_PRESSED)) {
                if (cellModelGrid[row][col].isMineBlown()) {
                    mineBlown();
                } else {
                    buttonsRemaining--;
                    if (buttonsRemaining <= 0) {
                        JOptionPane.showMessageDialog(null, "You've Won!!!", "Congratulations",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                    if (cellModelGrid[row][col].getValue() == 0) {
                        zeroValuePress(row, col);
                    }
                }
            }
        }

        private void mineBlown() {
            for (int r = 0; r < cellModelGrid.length; r++) {
                for (int c = 0; c < cellModelGrid[r].length; c++) {
                    MineCellModel model = cellModelGrid[r][c];
                    if (model.isMined()) {
                        model.setMineBlown(true);
                    }
                }
            }

        }

        private void zeroValuePress(int row, int col) {
            int rMin = Math.max(row - 1, 0);
            int cMin = Math.max(col - 1, 0);
            int rMax = Math.min(row + 1, cellModelGrid.length - 1);
            int cMax = Math.min(col + 1, cellModelGrid[row].length - 1);
            for (int row2 = rMin; row2 <= rMax; row2++) {
                for (int col2 = cMin; col2 <= cMax; col2++) {
                    cellModelGrid[row2][col2].pressedAction();
                }
            }
        }
    }
}

@SuppressWarnings("serial")
class MineCell extends JPanel {
    private static final String LABEL = "label";
    private static final String BUTTON = "button";
    private static final int PS_WIDTH = 24;
    private static final int PS_HEIGHT = PS_WIDTH;
    private static final float LABEL_FONT_SIZE = (float) (24 * PS_WIDTH) / 30f;
    private static final float BUTTON_FONT_SIZE = (float) (14 * PS_WIDTH) / 30f;
    private JButton button = new JButton();
    private JLabel label = new JLabel(" ", SwingConstants.CENTER);
    private CardLayout cardLayout = new CardLayout();
    private MineCellModel model;

    public MineCell(final boolean mined, int row, int col) {
        model = new MineCellModel(mined, row, col);
        model.addPropertyChangeListener(new MyPCListener());
        label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
        button.setFont(button.getFont().deriveFont(Font.PLAIN, BUTTON_FONT_SIZE));
        button.setMargin(new Insets(1, 1, 1, 1));
        setLayout(cardLayout);

        add(button, BUTTON);
        add(label, LABEL);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pressedAction();
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    model.upDateButtonFlag();
                }
            }
        });
    }

    public MineCell(int row, int col) {
        this(false, row, col);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PS_WIDTH, PS_HEIGHT);
    }

    public void pressedAction() {
        if (model.isFlagged()) {
            return;
        }
        model.pressedAction();
    }

    public void showCard(String cardConstant) {
        cardLayout.show(this, cardConstant);
    }

    // TODO: have this change the button's icon
    public void setFlag(boolean flag) {
        if (flag) {
            button.setBackground(Color.yellow);
            button.setForeground(Color.red);
            button.setText("f");
        } else {
            button.setBackground(null);
            button.setForeground(null);
            button.setText("");
        }
    }

    private void setMineBlown(boolean mineBlown) {
        if (mineBlown) {
            label.setBackground(Color.red);
            label.setOpaque(true);
            showCard(LABEL);
        } else {
            label.setBackground(null);
        }
    }

    public MineCellModel getModel() {
        return model;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        model.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        model.removePropertyChangeListener(listener);
    }

    private class MyPCListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            String propName = evt.getPropertyName();
            if (propName.equals(MineCellModel.MINE_BLOWN)) {
                setMineBlown(true);
            } else if (propName.equals(MineCellModel.FLAG_CHANGE)) {
                setFlag(model.isFlagged());
            } else if (propName.equals(MineCellModel.BUTTON_PRESSED)) {
                if (model.isMineBlown()) {
                    setMineBlown(true);
                } else {
                    String labelText = (model.getValue() == 0) ? ""
                            : String.valueOf(model.getValue());
                    label.setText(labelText);
                }
                showCard(LABEL);
            }
        }
    }

    public void reset() {
        setFlag(false);
        setMineBlown(false);
        showCard(BUTTON);
        label.setText("");
    }

}

class MineCellModel {
    public static final String FLAG_CHANGE = "Flag Change";
    public static final String BUTTON_PRESSED = "Button Pressed";
    public static final String MINE_BLOWN = "Mine Blown";
    private int row;
    private int col;
    private int value = 0;
    private boolean mined = false;;
    private boolean flagged = false;
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private boolean pressed = false;
    private boolean mineBlown = false;

    public MineCellModel(boolean mined, int row, int col) {
        this.mined = mined;
        this.row = row;
        this.col = col;
    }

    public void incrementValue() {
        int temp = value + 1;
        setValue(temp);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setMineBlown(boolean mineBlown) {
        this.mineBlown = mineBlown;
        PropertyChangeEvent evt = new PropertyChangeEvent(this, MINE_BLOWN, false, true);
        pcSupport.firePropertyChange(evt);
    }

    public boolean isMineBlown() {
        return mineBlown;
    }

    public void setMined(boolean mined) {
        this.mined = mined;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isMined() {
        return mined;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void pressedAction() {
        if (pressed) {
            return;
        }
        pressed = true;
        if (mined) {
            setMineBlown(true);
        }

        PropertyChangeEvent evt = new PropertyChangeEvent(this, BUTTON_PRESSED, -1, value);
        pcSupport.firePropertyChange(evt);
    }

    public void upDateButtonFlag() {
        boolean oldValue = flagged;
        setFlagged(!flagged);
        PropertyChangeEvent evt = new PropertyChangeEvent(this, FLAG_CHANGE, oldValue, flagged);
        pcSupport.firePropertyChange(evt);
    }

    public void reset() {
        mined = false;
        flagged = false;
        pressed = false;
        mineBlown = false;
        value = 0;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }
}