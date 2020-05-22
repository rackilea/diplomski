import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Example {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    public Example() {

        JFrame frame = new JFrame();

        MyTextPane textPane = new MyTextPane();
        textPane.getColoredWordsMap().put("SELECT", Color.RED);
        textPane.getColoredWordsMap().put("FROM", Color.WHITE);
        textPane.getColoredWordsMap().put("WHERE", Color.GREEN);

        frame.getContentPane().add(textPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private class MyTextPane extends JTextPane {

        private boolean human = true;
        private HashMap<String, Color> coloredWordsMap = new HashMap<String, Color>();

        public MyTextPane() {
            setBackground(Color.GRAY);
            getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateText();
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateText();
                }
            });
        }

        private void updateText() {
            if (human) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        human = false;
                        JTextPane textPane = MyTextPane.this;
                        boolean spaceBar = false;
                        if (textPane.getText().length() > 0
                                && textPane.getText().substring(textPane.getText().length() - 1).equals(" ")) {
                            spaceBar = true;
                        }
                        String[] words = textPane.getText().split(" ");
                        textPane.setText("");
                        for (String word : words) {
                            // This is not a mistake. The .equals method would
                            // just compare the content of the strings.
                            String toAppend = (words[words.length - 1] == (word)) ? "" : " ";
                            boolean colored = false;
                            for (String coloredWord : getColoredWordsMap().keySet()) {
                                if (word.equals(coloredWord)) {
                                    append(word + toAppend, getColoredWordsMap().get(coloredWord));
                                    colored = true;
                                }
                            }
                            if (!colored) {
                                append(word + toAppend, Color.BLACK);
                            }
                        }
                        if (spaceBar) {
                            append(" ", Color.BLACK);
                        }
                        human = true;
                    }
                });
            }
        }

        private void append(String text, Color color) {
            JTextPane textPane = MyTextPane.this;
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
            int length = textPane.getDocument().getLength();
            textPane.setCaretPosition(length);
            textPane.setCharacterAttributes(aset, false);
            textPane.replaceSelection(text);
        }

        public HashMap<String, Color> getColoredWordsMap() {
            return coloredWordsMap;
        }

    }

}