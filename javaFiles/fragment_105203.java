@Override
    public void onClick(View v) {
        if(flag){
           add = add +4;
           display.setText("2 + 2 =" + add);
        }
        else display.setText("Something else");
        flag=!flag;
}