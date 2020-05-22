btn_request_sms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            phone = inputPhone.getText().toString().trim();
            if (phone.length() == 13) {
                if (phone.startsWith("09")) {
                    phone = "+22" + phone.substring(1, phone.length());
                    runVerification(phone);
                } else {
                    Toast.makeText(getApplicationContext(), "Mobile number is wrong", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Mobile length is wrong", Toast.LENGTH_SHORT).show();
            }
        }
    });