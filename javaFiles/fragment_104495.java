button.setTag(0);//do this when you first initialize the button. You can even specify this in Xml with android:tag="0"
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         Button button = (Button) findViewById(R.id.button);
         button.setText("");
         final int status = (Integer) view.getTag();
         switch (status) {
             case 0:
                 button.setText("X");
                 view.setTag(1); //pause
                 break;
             case 1:
                 button.setText("O");
                 view.setTag(0); //pause
                 break;
         }
    }

});