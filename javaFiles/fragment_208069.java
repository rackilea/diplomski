public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            Sound s = new Sound("/Users/swhitehead/Downloads/checked.wav");

            JFrame f = new JFrame("Sound Meister");
            f.setFocusable(true);
            f.setSize(300, 300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            button = new JButton("Press to view 4 secs of music");
            f.add(button);
            button.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            s.play();
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            s.stop();
                        }
                    }
            );
            f.setVisible(true);
        }
    });

}