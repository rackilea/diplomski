layout = (ConstraintLayout)findViewById(R.id.container);
if (matched.length == 0) {
    layout.setBackgroundResource(R.drawable.background_safe);
    changeColor("#00FF00"); //assuming this is some local function?
    messageView.setText(messageSafe);
}
else{
    layout.setBackgroundResource(R.drawable.background_unsafe);
    changeColor("#FF0000");
    messageView.setText(messageUnSafe);
}