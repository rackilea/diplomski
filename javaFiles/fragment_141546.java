boolean result = false;
try{
   result =  Settings.canDrawOverlays(context);
}
catch(Throwable e){
    Log.e("error","error");
}