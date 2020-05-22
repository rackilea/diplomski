boolean tmp = false;
button.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
         tmp = !tmp;
         v.setBackgroundColor(tmp ? Color.RED : Color.BLUE);
    }
});