// the listener (aka: WindowManager)
    WindowListener l = new WindowAdapter() {
        List<Window> windows = new ArrayList<Window>();

        @Override
        public void windowOpened(WindowEvent e) {
            windows.add(e.getWindow());
        }

        @Override
        public void windowClosing(WindowEvent e) {
            if (windows.size() > 1) {
                windows.remove(e.getWindow());
                e.getWindow().dispose();
            }
        }
    };
    // create the first frame
    JFrame frame = createFrame(l);
    frame.setVisible(true);


// a method to create a new window, config and add the listener
    int counter = 0;
    private JFrame createFrame(final WindowListener l) {
        Action action = new AbstractAction("open new frame: " + counter) {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = createFrame(l);
                frame.setVisible(true);

            }
        };
        JFrame frame = new JFrame("someFrame " + counter++);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.add(new JButton(action));
        frame.addWindowListener(l);
        frame.pack();
        frame.setLocation(counter * 20, counter * 10);
        return frame;
    }