public class TestCheckboxes {

    public static void main(String[] args) {
        new TestCheckboxes();
    }

    public TestCheckboxes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new CheckBoxPane());
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class CheckBoxPane extends JPanel {

        private JPanel content;

        public CheckBoxPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            content = new JPanel(new GridBagLayout());
            add(content, gbc);

            JButton more = new JButton("More");
            more.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;

                    content.removeAll();
                    int count = 10 + (int) Math.round(Math.random() * 90);
                    System.out.println(count);
                    for (int index = 0; index < count; index++) {
                        gbc.gridx++;
                        if (index % 8 == 0) {
                            gbc.gridx = 0;
                            gbc.gridy++;
                        }
                        content.add(new JCheckBox(Integer.toString(index)), gbc);
                    }

                    content.revalidate();
                    repaint();

                }

            });

            gbc.gridy++;
            gbc.weightx = 0;
            gbc.weighty = 0;

            add(more, gbc);
        }
    }
}