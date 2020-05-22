Update:

 Button filterbutton;  
Button filterbutton = (Button)findViewById(R.id.filterbutton); }

       filterbutton.setOnClickListener(new View.OnClickListener() { 


             public void onClick(View v) { 

   v.setColorEffect(Camera.Parameters.EFFECT_AQUA); 
}