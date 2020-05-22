public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Play")) {
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        MenuFrame.setVisible(false);
        System.out.print("test play");
    } else if (e.getActionCommand().equals("Instructions")) {
        inst.setVisible(true);

        // suspected error
    }else if (e.getActionCommand().equals("Close")) {
            System.out.print("Test inst");
            inst.setVisible(false);

    } else if (e.getActionCommand().equals("Exit"))
        System.exit(0);
}