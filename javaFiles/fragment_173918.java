Button button = (Button)myDialog.findViewById(R.id.dialogcancelbutton);
button.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
    // TODO Auto-generated method stub
    myDialog.cancel();
}});