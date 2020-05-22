replaceAll.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        int caret_pos = text.getCaretPosition();
        if(regx.isSelected()){
            text.setText(text.getText().replace(
                    find_tf.getText().replace("\\n","\n").replace("\\t","\t"),
                    replace_tf.getText().replace("\\n","\n").replace("\\t","\t")));
        }
        else{
            text.setText(text.getText().replace(
                    find_tf.getText(),
                    replace_tf.getText()));
        }
        text.setCaretPosition(Math.min(caret_pos,text.getText().length()));
    }
});