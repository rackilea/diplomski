case A_JOKE:
    for (ActionListener l : btnChoice1.getActionListeners()) {
        btnChoice1.removeActionListener(l);
    }
    btnChoice1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            btnChoice1.setText("Choice 1");
            // btnChoice1.revalidate(); <- tried this but it isn't
            // working
            GoToBase();
        }
    });
    break;