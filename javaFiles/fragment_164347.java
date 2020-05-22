public class Example extends JFrame {

    static Example example;
    JPanel panel;

    String tagarr[] = {"swing", "java", "c++", "awt"};

    public Example() {
        setSize(new Dimension(500, 80));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);
        c.gridx = 0;
        c.gridy = 0;

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 20));
        panel.setLayout(new FlowLayout(1, 2, 2));
        panel.setBackground(Color.white);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.magenta));
        add(panel,c);
        JTextField t = new JTextField("type here", 10);
        t.setBorder(null);
        t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tagcheck(evt);
            }

            private void tagcheck(KeyEvent evt) {
                String s = t.getText();
                if (s.length() > 0) {
                    for (String tag : tagarr) {
                        if (s.equals(tag)) {
                            TagPanel tagp1 = new TagPanel(s);
                            panel.add(tagp1, panel.getComponentCount() - 1);
                            t.setText("");
                            repaint();
                            revalidate();
                        }
                    }
                }
            }
        });

        panel.add(t);
        setVisible(true);
    }

    public void removecomp(JPanel p) {
        panel.remove(p);
        repaint();
        revalidate();
    }

    public static void main(String[] args) {
        example = new Example();
    }
}