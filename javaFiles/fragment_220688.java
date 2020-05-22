public void newUserInput(View view) {
    LayoutInflater inflater = (LayoutInflater)
        Launch.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View inflatedView = inflater.inflate(R.layout.popup_layout,null,false);

    if (myOption == 0) {
        TextView tv = (TextView) inflatedView.findViewById(R.id.my_text_view);
        tv.setVisibility(TextView.INVISIBLE);
    }

    PopupWindow pw = new PopupWindow(inflatedView,300,400,true);

    pw.showAtLocation(findViewById(R.id.button1), Gravity.CENTER, 0, 0);
}