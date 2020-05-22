private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String currentString = textView.getText().toString();
            if(currentString.equals("secondNumber")){
                currentString = "firstNumber";
            }else{
                currentString = "secondNumber";
            }
            final String tempString = currentString;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(tempString);
                }
            });
            //Change the textview again after 5 seconds
            handler.postDelayed(runnable, 5000);
        }
    };