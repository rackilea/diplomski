class MyOnClickListener implements OnClickListener  
    {  
     private final int position;  
private Context ctx;

     public MyOnClickListener(int position, Context ctx)  
     {  
      this.position = position;  
this.ctx = ctx;
     }  

     public void onClick(View v)  
     {  
      // Preform a function based on the position  
      someFunction(this.position)  
      Intent i = new Intent(MyMain.this, MyNewActivity.class)
ctx.startActivity(i);
     }  
    }