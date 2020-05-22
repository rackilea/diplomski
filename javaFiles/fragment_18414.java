String EMPTY_SPACE="";

    JLabel [] jLabels ={lab_1, lab_2, lab_3};

    for (int i = 0; i < jLabels.length; i++) {
        jLabels[i].setText(i+EMPTY_SPACE);
    }