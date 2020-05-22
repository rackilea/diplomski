calcButton.setOnClickListener(new View.OnClickListener() {

        @Override//missing
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            calculateinterest();  // It is returning a String but you are not storing it anywhere. (Just Wondering)
       finish();  // I don't know why are you calling the finish() here. So I'm keeping it
        }
    });