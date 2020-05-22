@Override     
 public boolean onKeyDown(int keyCode, KeyEvent event) 
  {         
    if (keyCode == KeyEvent.KEYCODE_BACK) 
       {            
     // put your stuff here or just block the back button for perticular activity             
           return true;        
       }         
     return super.onKeyDown(keyCode, event); 
   }