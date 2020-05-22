public String doThis(){   
String url = "url of your servlet";   
 FacesContext context = FacesContext.getCurrentInstance();   
 try {   
  context.getExternalContext().dispatch(url);   
  }catch (Exception e) {   
       e.printStackTrace();   
}   
finally{   
   context.responseComplete();

return "";   
   }