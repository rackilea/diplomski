calculate.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //Toast.makeText(getApplicationContext(), (CharSequence) result, Toast.LENGTH_LONG).show();
           String resultValue = "";
            try {
             resultValue =  calculate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setText( resultValue);
        }