Main.aboutWindow = new JDialog();
    Main.aboutWindow.setTitle("About kingfisher a0.0.3");
    Main.aboutWindow.setSize(300,600);
    Main.aboutWindow.setModal(true);
        JMenuBar menubar = new JMenuBar();
            JMenu control = new JMenu("Control");
                JMenuItem quit = new JMenuItem("quit");
                    quit.addActionListener(new ActionListene121r() {
                        public void actionPerformed(ActionEvent event) {
                            Main.aboutWindow.setVisible(false);
                            }
                        }
                    );
                control.add(quit);
            menubar.add(control);

        Main.aboutWindow.setJMenuBar(menubar); //changed

    JLabel name = new JLabel("kingfisher");
    Main.aboutWindow.add(name);
    Main.aboutWindow.setVisible(false);