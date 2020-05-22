String s_id_string=(String)request.getParameter("s_id");       
int s_id=0;
if(s_id_string !=null || s_id_string !=""){
  s_id = Integer.parseInt(s_id_string);
}
else{
  s_id=0;//assign any value
}