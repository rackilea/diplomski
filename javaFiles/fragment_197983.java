import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Example {

    public Example() {

        JFrame frame = new JFrame();

        ArrayList<Object> elements = new ArrayList<Object>();
        ArrayList<String> texts = new ArrayList<String>();
        ListPanel listPanel = new ListPanel(elements, texts);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JTextField elementField = new JTextField(5);
                JTextArea textArea = new JTextArea(5, 10);

                JPanel panel = new JPanel();
                panel.add(new JLabel("Element:"));
                panel.add(elementField);
                panel.add(Box.createHorizontalStrut(15));
                panel.add(new JLabel("Text:"));
                panel.add(new JScrollPane(textArea));

                int result = JOptionPane.showConfirmDialog(frame, panel, "Element & Text",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    listPanel.addElementToList(elementField.getText(), textArea.getText());
                }
            }
        });

        JButton deleteButton = new JButton("Remove");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listPanel.getList().getSelectedValue() != null) {
                    listPanel.removeElementFromList(listPanel.getList().getSelectedValue());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        frame.add(listPanel);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}

class ListPanel extends JPanel {
    private JList<Object> list;
    private JToggleButton arrowButton;
    private ArrayList<String> texts;
    private JWindow popup;

    public ListPanel(ArrayList<Object> elements, ArrayList<String> texts) {

        this.texts = texts;

        popup = new JWindow();

        arrowButton = new JToggleButton("\u25B6");
        arrowButton.setMargin(new Insets(0, 0, 0, 0));
        arrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (arrowButton.isSelected()) {
                    Object value = list.getSelectedValue();
                    if (value != null) {
                        JLabel titleLabel = new JLabel(value.toString());
                        titleLabel.setBackground(Color.WHITE);
                        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
                        titleLabel.setHorizontalAlignment(JLabel.LEFT);

                        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        titlePanel.setBackground(Color.WHITE);
                        titlePanel.add(titleLabel);

                        JTextPane textPane = new JTextPane();
                        textPane.setEditable(false);
                        textPane.setText(texts.get(list.getSelectedIndex()));

                        JPanel contentPanel = new JPanel(new BorderLayout());
                        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        contentPanel.add(titlePanel, BorderLayout.NORTH);
                        contentPanel.add(textPane);

                        popup.setLocation(arrowButton.getLocationOnScreen().x + arrowButton.getWidth(),
                                arrowButton.getLocationOnScreen().y);
                        popup.setContentPane(contentPanel);
                        popup.revalidate();
                        popup.pack();
                        popup.setVisible(true);
                    }
                } else {
                    if (popup.isVisible()) {
                        popup.setVisible(false);
                    }
                }

            }
        });

        Timer timer = new Timer(100, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JFrame) SwingUtilities.getWindowAncestor(ListPanel.this)) != null) {
                    activateComponentListener();
                    timer.stop();
                }
            }
        });
        timer.start();

        list = new JList<Object>(new DefaultListModel<Object>());
        for (Object element : elements) {
            ((DefaultListModel<Object>) list.getModel()).addElement(element);
        }

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(arrowButton, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(null);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scrollPane);
        add(buttonPanel, BorderLayout.WEST);
    }

    private void activateComponentListener() {
        ((JFrame) SwingUtilities.getWindowAncestor(this)).addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent arg0) {
                if (popup.isVisible()) {
                    popup.setLocation(arrowButton.getLocationOnScreen().x + arrowButton.getWidth(),
                            arrowButton.getLocationOnScreen().y);
                }
            }
        });
    }

    public void removeElementFromList(Object element) {
        int index = getElementIndex(element);
        if (((DefaultListModel<Object>) getList().getModel()).getElementAt(getElementIndex(element)) != null) {
            ((DefaultListModel<Object>) getList().getModel()).removeElementAt(index);
            getTexts().remove(index);
        }
    }

    public void removeElementFromList(int index) {
        if (((DefaultListModel<Object>) getList().getModel()).getElementAt(index) != null) {
            ((DefaultListModel<Object>) getList().getModel()).removeElementAt(index);
            getTexts().remove(index);
        }
    }

    private Integer getElementIndex(Object element) {
        for (int i = 0; i < ((DefaultListModel<Object>) getList().getModel()).getSize(); i++) {
            if (((DefaultListModel<Object>) getList().getModel()).getElementAt(i).equals(element)) {
                return i;
            }
        }
        return null;
    }

    public void addElementToList(Object element, String text) {
        ((DefaultListModel<Object>) list.getModel()).addElement(element);
        getTexts().add(text);
    }

    public JList<Object> getList() {
        return list;
    }

    public JToggleButton getArrowButton() {
        return arrowButton;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

}