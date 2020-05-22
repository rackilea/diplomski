package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
/**
 * Author Samy
 */
public class Game {

    private GameModel model;

    private JFrame frame;

    public Game() throws HeadlessException {

        model = new GameModel();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("The Lottery - Version 1.0");
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());

        WinningsPanel wPanel = new WinningsPanel(model);
        frame.add(wPanel.getPanel(), BorderLayout.NORTH);

        ButtonPanel bPanel = new ButtonPanel(model);
        frame.add(bPanel.getPanel(), BorderLayout.SOUTH);

        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game().getFrame().setVisible(true);
            }
        });
    }

    public class LotteryLine {

        private double lowValue;
        private double highValue;

        private int prize;

        private NumberFormat nf = NumberFormat.getCurrencyInstance();

        public LotteryLine(double highValue, double lowValue, 
                int prize) {
            this.highValue = highValue;
            this.lowValue = lowValue;
            this.prize = prize;
        }

        public double getLowValue() {
            return lowValue;
        }

        public double getHighValue() {
            return highValue;
        }

        public int getPrize() {
            return prize;
        }

        public String getFormattedPrize() {
            return nf.format(prize);
        }

        public String getLeftPaddedPrize() {
            StringBuilder builder = new StringBuilder();
            String s = getFormattedPrize();

            for (int i = s.length(); i < 16; i++) {
                builder.append(' ');
            }
            builder.append(s);

            return builder.toString();
        }

    }

    public class GameModel {

        private double randomNumber;

        private List<LotteryLine> lotteryList;

        public GameModel() {
            this.lotteryList = new ArrayList<LotteryLine>();
            createLotteryList();
        }

        private void createLotteryList() {
            lotteryList.add(new LotteryLine(100D, 50D, 100));
            lotteryList.add(new LotteryLine(50D, 20D, 500));
            lotteryList.add(new LotteryLine(20D, 5D, 2000));
            lotteryList.add(new LotteryLine(5D, 1D, 5000));
            lotteryList.add(new LotteryLine(1D, 0.1D, 25000));
            lotteryList.add(new LotteryLine(0.1D, 0.01D, 50000));
            lotteryList.add(new LotteryLine(0.01D, 0.001D, 250000));
            lotteryList.add(new LotteryLine(0.001D, 0.0001D, 1000000));
        }

        public double generateRandomNumber() {
            this.randomNumber = Math.random() * 100D;
            return randomNumber;
        }

        public List<LotteryLine> getLotteryList() {
            return lotteryList;
        }

        public LotteryLine getLotteryLine(double randomNumber) {
            for (LotteryLine lotteryLine : lotteryList) {
                if (randomNumber > lotteryLine.getLowValue()) {
                    return lotteryLine;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public class WinningsPanel {

        private GameModel model;

        private JPanel panel;

        public WinningsPanel(GameModel model) {
            this.model = model;
            createPartControl();
        }

        private void createPartControl() {
            panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JPanel labelPanel = new JPanel();
            labelPanel.setLayout(new BoxLayout(
                    labelPanel, BoxLayout.PAGE_AXIS));

            JLabel writtenLabel = new JLabel("Written by: Samy");
            writtenLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            labelPanel.add(writtenLabel);

            labelPanel.add(Box.createVerticalStrut(20));

            JLabel prizeLabel = new JLabel("Prize Table");
            prizeLabel.setFont(new Font("default", Font.BOLD, 32));
            prizeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            labelPanel.add(prizeLabel);

            panel.add(labelPanel, BorderLayout.NORTH);

            LotteryTableModel tableModel = new LotteryTableModel(model);

            JTable lotteryTable = new JTable(tableModel);
            int height = tableModel.getRowCount() * 
                    lotteryTable.getRowHeight();
            lotteryTable.setPreferredScrollableViewportSize(
                    new Dimension(300, height));
            JScrollPane scrollPane = new JScrollPane(lotteryTable);
            panel.add(scrollPane, BorderLayout.CENTER);
        }

        public JPanel getPanel() {
            return panel;
        }

    }

    public class LotteryTableModel extends AbstractTableModel {

        private static final long   serialVersionUID    = 
                7330112393676204265L;

        private GameModel model;

        private String[] columns = {"High Value", "Low Value", "Prize"};

        public LotteryTableModel(GameModel model) {
            this.model = model;
        }

        @Override
        public int getRowCount() {
            return model.getLotteryList().size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columns[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                case 1:
                    return Double.class;
                case 2:
                    return String.class;
                default:
                    return String.class;
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            LotteryLine lotteryLine = 
                    model.getLotteryList().get(rowIndex);
            switch (columnIndex) {
            case 0: return lotteryLine.getHighValue();
            case 1: return lotteryLine.getLowValue();
            case 2: return lotteryLine.getLeftPaddedPrize();
            default: return "";
            }
        }

    }

    public class ButtonPanel {

        private GameModel model;

        private JLabel numberLabel;
        private JLabel prizeLabel;

        private JPanel panel;

        public ButtonPanel(GameModel model) {
            this.model = model;
            createPartControl();
        }

        private void createPartControl() {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            panel.add(Box.createVerticalStrut(10));

            JButton playButton = new JButton("Pick Number");
            playButton.addActionListener(new PickNumberActionListener());
            playButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            panel.add(playButton);

            panel.add(Box.createVerticalStrut(20));

            numberLabel = new JLabel(" ");
            numberLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            panel.add(numberLabel);

            prizeLabel = new JLabel(" ");
            prizeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            panel.add(prizeLabel);
        }

        public void updateNumberLabel(double number) {
            StringBuilder builder = new StringBuilder();
            builder.append("Your number is ");
            builder.append(String.format("%.4f", number));
            numberLabel.setText(builder.toString());
        }

        public void updatePrizeLabel(String prize) {
            StringBuilder builder = new StringBuilder();
            builder.append("You've won ");
            builder.append(prize);
            prizeLabel.setText(builder.toString());
        }

        public JPanel getPanel() {
            return panel;
        }

        public class PickNumberActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                double number = model.generateRandomNumber();
                LotteryLine lotteryLine = model.getLotteryLine(number);
                updateNumberLabel(number);
                updatePrizeLabel(lotteryLine.getFormattedPrize());
            }

        }

    }
}