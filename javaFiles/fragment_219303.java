b1.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        Random random1 = new Random();
        int Int1 = random1.nextInt(11);
        lable.setText(Integer.toString(Int1));
    }

});