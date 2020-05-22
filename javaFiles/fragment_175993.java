call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BloodVaultItem bloodVaultItem = getItem(position);

                String number = bloodVaultItem.getContact();

                BloodVaultActivity2 bloodVaultActivity2 = new BloodVaultActivity2();
                bloodVaultActivity2.number = number;
                bloodVaultActivity2.makephonecall(context);
            }
        });