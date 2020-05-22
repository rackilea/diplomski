boolean isASCII(String str){
    for(int i=0;i<str.length();i++){
        if(str.charAt(i) >= 128)
            return false;
    }
    return true;
}

@Override
public void afterTextChanged(Editable editable) {
   String SMSText = mSMS.getText().toString();
   String SMSLimit = "160";
   SmsManager manager = SmsManager.getDefault();
   ArrayList<String> messageParts = manager.divideMessage(SMSText);
   if(messageParts.size() > 1){

     String smsStr = messageParts.get(0);
     if(!isASCII(smsStr)) SMSLimit = "70";
   }
   mCounter.setText(String.valueOf(SMSText.length()) + " / " + SMSLimit);
 }