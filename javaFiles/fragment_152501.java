private void setCustomText(TextView textView, String[] msg, boolean isSingleLine){
    if(isSingleLine)
        textView.setText(msg[0]);
    else
        textView.setText(TextUtils.join("<br/>", msg));
}