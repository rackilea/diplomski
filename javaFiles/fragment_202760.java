@Override
public void onClick(View sendEmailClick) {
    emailAdd = setEmailAddress.getText().toString();
    emailSub = setEmailSubject.getText().toString();
    emailMess = setEmailMessage.getText().toString();
    Intent sendEmailIntent = new Intent(Intent.ACTION_SEND); 
    sendEmailIntent.setType("plain/text");
    sendEmailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {emailAdd});  
    sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSub); 
    sendEmailIntent.putExtra(Intent.EXTRA_TEXT, emailMess); 
    startActivity(Intent.createChooser(sendEmailIntent, "Send mail..."));
}