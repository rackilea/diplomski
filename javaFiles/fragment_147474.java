boolean void validateInput(){
boolean retStatus=false;
if((textView1.getText().length()==0 ||  textView1.getText().equals("") && (any other condition )){
   retStatus=true;
   textView1.setError("You have entered wrong value in textView 1");
}
//similarly for other controls
------ 
-----
--

return retStatus;
}