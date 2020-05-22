public class GridbagDragDemo extends JPanel {

        /**
         * Pixel width and height of positioned component.
         */
        private float  width, height;

        /**
         * Layout manger for this.
         */
        private GridBagLayout gbl;

        /**
         * Layout horizontal weights for left and right gap, and component.
         */
        private float leftWeight,xCompWeight, rightWeight;

        /**
         * Layout vertical weights for top and right gap, and component.
         */
        private float topWeight,yCompWeight, bottomWeight;

        /**
         * Min and max weight values.
         * These values can be changed to change the sensitivity of dragging.
         * For better responsiveness W_MAX can be changed in respect to the JPanl's size.
         * (also a different W_MAX can be set to horizontal and vertical axis.
         */
        private float W_MIN = 0, W_MAX = 2;

        /**
         * Keep sum an even number for calculating (int) W_SUM/2
         */
        private float W_SUM = W_MIN + W_MAX;

        /**
         * Represents the change in ratio between left / right weights
         * and top/bottom weights for every pixel of mouse drag.
         * The higher the factor the faster / more sensitive the
         * component move is.
         * Try different values to get the responsiveness you need.
         */
        private float WEIGHT_DELTA = 0.01f;

        /**
         * Represents the change (in pixels) in component width and height
         * and top/bottom weights for every mouse wheel notch.
         * The higher the factor the faster / more sensitive the
         * component resize.
         * Try different values to get the responsiveness you need.
         */
        private static final int ZOOM_FACTOR = 4;

        /**
         * Store mouse pressed position.
         */
        private float pX, pY;

        /**
         * The dragged component
         */
        private JComponent component;

        public GridbagDragDemo() {

            //set initial position to center
            leftWeight = W_SUM/2 ; xCompWeight = 0;  rightWeight = W_SUM/2;
            topWeight = W_SUM/2 ; yCompWeight = 0;  bottomWeight = W_SUM/2;

            gbl = new GridBagLayout();
            gbl.columnWidths = new int[] {0, 0, 0};
            gbl.rowHeights = new int[] {0, 0, 0};
            gbl.columnWeights = new double[]{leftWeight , xCompWeight, rightWeight };
            gbl.rowWeights = new double[]{topWeight,yCompWeight, bottomWeight};
            setLayout(gbl);
            setBackground(Color.YELLOW);

            component = new JPanel();
            component.setPreferredSize(new Dimension(75,75));
            component.setMinimumSize(new Dimension(15,15));
            component.setMaximumSize(new Dimension(225,225));
            component.setBackground(Color.ORANGE);
            component.setBorder(new LineBorder(Color.black, 3));

            //add drag listeners
            component.addMouseMotionListener(new MouseMotionAdapter(){
                @Override
                public void mouseDragged(MouseEvent me) {

                    int mouseX = me.getXOnScreen();
                    int mouseY = me.getYOnScreen();

                    float moveX  =  mouseX - pX;
                    float moveY  =  mouseY - pY;

                    pX = mouseX;
                    pY = mouseY;

                    moveComp(moveX , moveY);

                }
            });
            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {

                    //store pressed position
                    pX = me.getXOnScreen();
                    pY = me.getYOnScreen();
                }
            });

            //add resize listener
            component.addMouseWheelListener(new MouseWheelListener() {

                @Override
                public void mouseWheelMoved(MouseWheelEvent me) {

                    //change sign so rolling "up" will be positive
                    reSizeComp(- me.getWheelRotation());
                }
            });

            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.gridx = 1;
            gbc_panel.gridy = 1;
            add(component, gbc_panel);

            width  = component.getPreferredSize().width;
            height = component.getPreferredSize().height;
        }

        private void moveComp(float moveX, float moveY) {

            if(Math.abs(moveX)>0) {

                leftWeight += WEIGHT_DELTA * moveX;
                leftWeight = (float) setValueInRange(leftWeight,  W_MIN, W_MAX);
                rightWeight = W_SUM - leftWeight;
            }

            if(Math.abs(moveY)>0) {

                topWeight += WEIGHT_DELTA * moveY;
                topWeight = (float) setValueInRange(topWeight, W_MIN, W_MAX );
                bottomWeight = W_SUM - topWeight;
            }

            gbl.columnWeights = new double[]{leftWeight,xCompWeight, rightWeight};
            gbl.rowWeights    = new double[]{topWeight, yCompWeight, bottomWeight};

            refresh();
        }

        /**
         *
         */
        private void refresh() {

            revalidate();
            getParent().repaint();
        }

        private void reSizeComp(int notches) {

            width += notches*ZOOM_FACTOR  ; height += notches *ZOOM_FACTOR  ;

            //respect min / max component size
            width  = (float) setValueInRange(width, component.getMinimumSize().getWidth(),
                                                        component.getMaximumSize().getWidth() );
            height = (float) setValueInRange(height, component.getMinimumSize().getHeight(),
                                                        component.getMaximumSize().getHeight() );
            component.setPreferredSize(new Dimension((int)width,(int)height));

            refresh();
        }

        private double setValueInRange(double value, double min, double max) {

            value = (value < min ) ? min : value;
            value = (value > max ) ? max : value;

            return value;
        }

        public static void main(String args[]) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {

                    JFrame frame = new JFrame("Test Gridbag drag");
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(400, 300));
                    frame.getContentPane().setLayout(new BorderLayout());

                    frame.getContentPane().add(new GridbagDragDemo(), BorderLayout.CENTER);

                    frame.setVisible(true);
                    frame.pack();
                }
            });
        }
    }