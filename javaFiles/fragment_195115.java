public class BadLayout03 {

    public static void main(String[] args) {
        new BadLayout03();
    }

    public BadLayout03() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MasterPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MasterPane extends JPanel {

        public MasterPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;
            add(new DimensionsPane(), gbc);
            gbc.gridy++;
            add(new ColorPane(), gbc);
            gbc.gridy++;
            add(new ReinforementPane(), gbc);
            gbc.gridy++;
            add(new SealableTopPane(), gbc);
            gbc.gridy++;
            add(new CardGradePane(), gbc);
            gbc.gridy++;
            add(new QuantityPane(), gbc);
            gbc.gridy++;
            add(new OrderPricePane(), gbc);
        }

    }

    public class DimensionsPane extends JPanel {

        public DimensionsPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Dimensions of box (m):"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("Length: 33.0"), gbc);
            gbc.gridy++;
            add(new JLabel("Width: 3.0"), gbc);
            gbc.gridy++;
            add(new JLabel("Height: 3.0"), gbc);
        }

    }

    public class ColorPane extends JPanel {

        public ColorPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Colour :"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("0"), gbc);
        }

    }

    public class ReinforementPane extends JPanel {

        public ReinforementPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Reinforcement :"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("None"), gbc);
        }

    }

    public class SealableTopPane extends JPanel {

        public SealableTopPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Selable top :"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("No"), gbc);
        }

    }

    public class CardGradePane extends JPanel {

        public CardGradePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Grade of card:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("1"), gbc);
        }

    }

    public class QuantityPane extends JPanel {

        public QuantityPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Quantity:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("1"), gbc);
        }

    }

    public class OrderPricePane extends JPanel {

        public OrderPricePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Order price:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(new JLabel("$558.9"), gbc);
        }

    }

}