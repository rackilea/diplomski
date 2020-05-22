String text = jLabelObject.getText();
try{
    if(!text.isEmpty()){
        jLabelObject.setText(text.substring(0, text.length()-1);
    }
}catch(NullPointerException e){
    jLabelObject.setText("");
}