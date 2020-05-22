/******** Listener for button click ********/
    bparsejson.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "Button Pushed");
            JSONParser jp = new JSONParser();
            output.setText(jp.parsesData(strJson, outputData));
        }
    });