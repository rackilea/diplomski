public class MapDisplay {

    private JFrame frame;
    private LinePanel jpanel;

    public MapDisplay(Map map) {
        this.frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                jpanel.repaint();
            }
        });
        jpanel = new LinePanel(map);
        frame.add(jpanel, BorderLayout.CENTER);
    }

    public void display() {
        frame.setSize(710, 935);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jpanel.repaint();
    }

    class LinePanel extends JPanel {

        private static final long serialVersionUID = 1965018056953712219L;
        private Map map;
        private int width;
        private int height;

        private int latAsY(double lat) {
            return height
                            - (int) (height * (lat - map.getMinLat()) / (map
                            .getMaxLat() - map.getMinLat()));
        }

        private int lonAsX(double lon) {
            return (int) (width * (lon - map.getMinLong()) / (map.getMaxLong() - map
                            .getMinLong()));
        }

        private void recalculateDimensions() {
            double mapRatio = (map.getMaxLat() - map.getMinLat())
                            / (map.getMaxLong() - map.getMinLong());
            double panelRatio = this.getHeight() / (double) this.getWidth();
            if (mapRatio > panelRatio) {
                width = (int) (this.getHeight() / mapRatio);
                height = this.getHeight();
            } else {
                width = this.getWidth();
                height = (int) (mapRatio * this.getWidth());
            }
        }

        public LinePanel(Map map) {
            super();
            this.map = map;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (map != null) {
                recalculateDimensions();
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setStroke(new BasicStroke(2));
                g2d.clearRect(0, 0, jpanel.getWidth(), jpanel.getHeight());
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, width, height);
                g2d.setColor(Color.BLACK);
                for (String wayId : map.getWays()) {
                    Way way = map.getWay(wayId);
                    Node prev = null;
                    for (String nodeId : way.getNodes()) {
                        Node cur = map.getNode(nodeId);
                        if (prev != null) {
                            int y1 = latAsY(prev.getLatitude());
                            int x1 = lonAsX(prev.getLongitude());
                            int y2 = latAsY(cur.getLatitude());
                            int x2 = lonAsX(cur.getLongitude());
                            g2d.drawLine(x1, y1, x2, y2);
                        }
                        prev = cur;
                    }
                }
                g2d.dispose();
            }
        }
    }
}