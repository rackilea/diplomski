b1.setOnClickListener(new View.OnClickListener(){

    public void onClick(View v){

        String name,age,contact;

         name=et1.getText().toString();
         age=et2.getText().toString();
         contact=et3.getText().toString();

        tv.setText(name + " "+ age + " "+contact);
    }
});