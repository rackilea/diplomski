String msg="Invalid Response";
if(response.length()>499){
    msg=response.substring(0,500);
}
mTextView.setText("Response is: "+msg);

//or     mTextView.setText("Response is: "+response);