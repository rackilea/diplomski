replaceAll.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        int caret_pos = text.getCaretPosition();
        if(regx.isSelected()){
            text.setText(text.getText().replaceAll(
                    find_tf.getText(), replace_tf.getText()));
        }
        else{
            text.setText(text.getText().replace(
                    find_tf.getText(), replace_tf.getText()));
        }
        text.setCaretPosition(Math.min(caret_pos,text.getText().length()));
    }
});