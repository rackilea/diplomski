JCheckBox cb = new JCheckBox();
ImgPanel p = new ImgPanel();

cb.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        if(cb.isSelected){
            p.set(0);
        } else {
            p.set(-1);
        }
    }
});