// Call Back method  to get the Message form other Activity  
@Override  
protected void onActivityResult(int requestCode, int resultCode, Intent data)  
{  
super.onActivityResult(requestCode, resultCode, data);  
// check if the request code is same as what is passed  here it is 2  
  if(requestCode==2)  
    {  
     //Do your task here 
    }  
}