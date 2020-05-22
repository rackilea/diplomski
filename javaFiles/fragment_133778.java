kileri.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            sendData("F");
            try {
                //set time in mili
                Thread.sleep(3000);

            }catch (Exception e){
                e.printStackTrace();
            }
            sendData("S");
        }
    });