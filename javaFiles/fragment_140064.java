if (TextUtils.isEmpty(email)){
    Toast.makeText(this, getResources()"email is empty", Toast.LENGTH_SHORT).show();
    //set cursor in Email editText
    emailE.requestFocus();
    return;
}
if(TextUtils.isEmpty(password)){
    Toast.makeText(this,"password is empty", Toast.LENGTH_SHORT).show();
    //set cursor in Password editText
   passwordE.requestFocus();
    return;
}