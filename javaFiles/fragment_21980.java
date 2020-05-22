try{
 //.....your code here...
while ((str= reader.readLine()) != null) {
       output += "\r\n" + str;
     }
Your_Current_Activity.this.runOnUiThread(new Runnable() {
    public void run() {
        createMsg(output,"Debug"); // show message here
    }
});

  return true;
}catch(Exception e){
   //use runOnUiThread for showing Alert here....
  return false;

}