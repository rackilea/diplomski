private void setupEvents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i=0; i<10; i++) {
            final int finalI = i;
            cb[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text[finalI].setEnabled(!text[finalI].isEnabled() && e.getID() == ActionEvent.ACTION_PERFORMED);
                }
            });
        }
    }