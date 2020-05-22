b.setOnClickListener(new OnClickListener(){
   @Override
   public void onClick(View v) 
   {
       if(b.isChecked())
            t.setText("I'm turned on");
       else
            t.setText("I'm turned off"); 
   }    
});