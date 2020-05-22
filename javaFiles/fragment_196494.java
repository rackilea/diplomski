ArrayList<String> sentNumbers = new ArrayList<>();
Button but = (Button) a;
but.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
         String messageToSend = "message";
         LoginDataBaseAdapter loginDataBaseAdapter = HomeActivity.loginDataBaseAdapter;
        car = ((EditText) b ).getText().toString();
        String phoneNum = loginDataBaseAdapter.getNum(car);
        if(!sentNumbers.isEmpty(){
            for (String string : sentList){
                if (!string.equalsIgnoreCase(phoneNum)) {
                    SmsManager.getDefault().sendTextMessage(phoneNum, null, messageToSend, null, null);
                    sentNumbers.add(phoneNum);
                    Toast.makeText(view.getContext(), "MESSAGE SUCCESSFULLY SENT",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(view.getContext(), "No Car Number found",Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            SmsManager.getDefault().sendTextMessage(phoneNum, null, messageToSend, null, null);
            sentNumbers.add(phoneNum);
        }
    }
});