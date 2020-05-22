if (level == 0 && source.getClassName().equals("android.widget.TextView") && source.getText()!=null && !source.getText().toString().isEmpty()){
    // here level is iteration of for loop
    String recivedText = source.getText().toString(); 
    if(source.getClassName().equals("android.widget.TextView") && source.getParent()!=null && source.getParent().getClassName().equals("android.widget.FrameLayout") && source.getParent().getParent()==null){ 
        return recivedText;
    }
}