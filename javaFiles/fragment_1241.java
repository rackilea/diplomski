JFrame f = new JFrame("Test");
    f.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println(e);
        }
    });