@Override
public void onCreate(Bundle savedInstanceState) {
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
}

private OnClickListener onClickListener = new OnClickListener() {
     @Override
     public void onClick(final View v) {
         switch(v.getId()){
             case R.id.button1:
                  //DO something
             break;
             case R.id.button2:
                  //DO something
             break;
             case R.id.button3:
                  //DO something
             break;
         }

   }
};