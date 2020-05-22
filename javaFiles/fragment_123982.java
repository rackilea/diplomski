if(result.contains("Remote login success")){
    Intent i = new Intent(context, MainpanelActivity.class); //use context here
    i.putExtra("email", this.email); 
    startActivity(i); 

}