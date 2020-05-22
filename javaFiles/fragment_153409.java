ok.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View arg0) {
         strvalue1 = value1.getText().toString();
         strvalue2 = value2.getText().toString();
         stroperator = myoperator.getText().toString();

         ivalue1 =  Integer.valueOf(strvalue1);
         ivalue2 =  Integer.valueOf(strvalue2);

        if (stroperator.equals("+")) {

           Toast.makeText(MainActivity.this, "If is running", Toast.LENGTH_LONG).show();

            }

    }
});