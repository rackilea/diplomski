hard.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent l) {
        String level = l.getActionCommand();
        if (level.equals("Hard")) {
            ballXSpeed = 190;
            ballSpeed = 184;
            //frame.remove(panellevel);
            //frame.add(panel);
            //frame.validate();
            timer.start();
            cardLayout.show(frame.getContentPane(), "game");
        }
    }
});