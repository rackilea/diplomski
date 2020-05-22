final List<JFrame> jframeList = new ArrayList<JFrame>();

    JFrame jFrame = new JFrame();
    jframeList.add(jFrame);

    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    jFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            JFrame jframe = (JFrame) e.getSource();
            jframeList.remove(jframe);
            if (jframeList.isEmpty()) {
                System.exit(0);
            }
        }
    });