public class ResizableImagePane {

    public static void main(String[] args) {
        new ResizableImagePane();
    }

    public ResizableImagePane() {
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
                frame.add(new ScalerPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected class ScalerPane extends JPanel {
        private JSlider slider;
        private ImagePane imagePane;
        public ScalerPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;

            imagePane = new ImagePane();

            add(imagePane, gbc);

            gbc.gridy = 1;
            gbc.weightx = 0;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            slider = new JSlider();
            slider.setMinimum(1);
            slider.setMaximum(100);
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.SOUTH;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(slider, gbc);

            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    imagePane.setZoom(slider.getValue() / 100f);
                }
            });
            slider.setValue(100);
        }
    }

    protected class ImagePane extends JPanel {
        private BufferedImage background;
        private Image scaled;
        private float zoom;
        public ImagePane() {
            try {
                background = ImageIO.read(new File("path/to/your/image"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setZoom(1f);
            setBorder(new LineBorder(Color.RED));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(scaled.getWidth(this), scaled.getHeight(this));
        }

        public void setZoom(float zoom) {
            this.zoom = zoom;
            int width = Math.round(background.getWidth() * zoom);
            scaled = background.getScaledInstance(width, -1, Image.SCALE_SMOOTH);

            invalidate();
            revalidate();
            repaint();
        }

        public float getZoom() {
            return zoom;
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);

            int x = (getWidth() - scaled.getWidth(this)) / 2;
            int y = (getHeight() - scaled.getHeight(this)) / 2;

            grphcs.drawImage(scaled, x, y, this);
        }
    }
}