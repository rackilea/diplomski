private void setupEvents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i=0; i<10; i++) {
            final int finalI = i;
            cb[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    text[finalI].setEnabled(e.getStateChange() == ItemEvent.SELECTED);
                }
            });
        }
    }