private static JLabel add_bed(String sex, int x, int y){
    JLabel bed = null;

    if (sex == "female"){
        bed = new JLabel(femaleBed);
        GridBagConstraints gbc_lfemalebed = new GridBagConstraints();
        gbc_lfemalebed.insets = new Insets(0, 0, 0, 0);
        gbc_lfemalebed.gridx = x;
        gbc_lfemalebed.gridy = y;
        bedsPane.add(lfemalebed, gbc_lfemalebed);
    }else if (sex == "male"){
        lmalebed = new JLabel(maleBed);
        GridBagConstraints gbc_lmalebed = new GridBagConstraints();
        gbc_lmalebed.insets = new Insets(0, 0, 0, 0);
        gbc_lmalebed.gridx = x;
        gbc_lmalebed.gridy = y;
        bedsPane.add(lmalebed, gbc_lmalebed);
    }


    return bed;
}