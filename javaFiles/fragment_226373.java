Start.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent i) {
        String action = i.getActionCommand();
        if (action.equals("Start")) {
            //frame.remove(panelstart);
            //frame.add(panellevel);
            //frame.validate();
            cardLayout.show(frame.getContentPane(), "level");
        }
    }
});