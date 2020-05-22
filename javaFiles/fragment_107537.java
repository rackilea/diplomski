import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SelectionSortAnimate extends JPanel {

    private static final int NUM_OF_ITEMS = 20;
    private static final int DIM_W = 400;
    private static final int DIM_H = 400;
    private static final int HORIZON = 350;
    private static final int VERT_INC = 15;
    private static final int HOR_INC = DIM_W / NUM_OF_ITEMS;

    private JButton startButton;
    private Timer timer = null;
    private JButton resetButton;

    Integer[] list;
    int currentIndex = NUM_OF_ITEMS - 1;

    public SelectionSortAnimate() {
        list = initList();

        timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSortingDone()) {
                    ((Timer) e.getSource()).stop();
                    startButton.setEnabled(false);
                } else {
                    sortOnlyOneItem();
                }
                repaint();
            }
        });
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list = initList();
                currentIndex = NUM_OF_ITEMS - 1;
                repaint();
                startButton.setEnabled(true);
            }
        });
        add(startButton);
        add(resetButton);
    }

    public boolean isSortingDone() {
        return currentIndex == 0;
    }

    public Integer[] initList() {
        Integer[] nums = new Integer[NUM_OF_ITEMS];
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = i;
        }
        Collections.shuffle(Arrays.asList(nums));
        return nums;
    }

    public void drawItem(Graphics g, int item, int index) {
        int height = item * VERT_INC;
        int y = HORIZON - height;
        int x = index * HOR_INC;
        g.fillRect(x, y, HOR_INC, height);
    }

    public void sortOnlyOneItem() {
        int currentMax = list[0];
        int currentMaxIndex = 0;

        for (int j = 1; j <= currentIndex; j++) {
            if (currentMax < list[j]) {
                currentMax = list[j];
                currentMaxIndex = j;
            }
        }

        if (currentMaxIndex != currentIndex) {
            list[currentMaxIndex] = list[currentIndex];
            list[currentIndex] = currentMax;
        }
        currentIndex--;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < list.length; i++) {
            drawItem(g, list[i], i);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DIM_W, DIM_H);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Sort");
                frame.add(new SelectionSortAnimate());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}