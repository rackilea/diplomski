int c = 0;

for (int i=0; i<4; i++) {
    for(int j=0; j<4; j++){
        String number = Integer.toString(list.get(c));
        c++;

        JButton btnmix = new JButton();
        btnBotonMix[i][j] = btnmix;
        btnBotonMix[i][j].setText(number);
    }
}