function processResponse(){
  //check whether the response form the server is intact and correct
   if(reqObject.status==200 && reqObject.readyState==200){
     //simply means we got the response correctly
     //Now you can get the response by
     var res = reqObject.responseText;

   }    
}