int serviceNumber = 0;

    void OpenDialogService() {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_new_order2);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        TextView headerTxt = (TextView) dialog.findViewById(R.id.headerTxt);
        TextView okTxt = (TextView) dialog.findViewById(R.id.okTxt);
        TextView cancelTxt = (TextView) dialog.findViewById(R.id.cancelTxt);
        TextView primaryTxt = (TextView) dialog.findViewById(R.id.primaryTxt);
        TextView otherTxt = (TextView) dialog.findViewById(R.id.otherTxt);
        TextView primaryContentTxt = (TextView) dialog.findViewById(R.id.primaryContentTxt);
        LinearLayout closeLyt = (LinearLayout) dialog.findViewById(R.id.closeLyt);

        // Radio Buttons

        final RadioGroup radio = (RadioGroup) dialog.findViewById(R.id.radioGroup1);
        radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                  View radioButton = radio.findViewById(checkedId);
                    int index = radio.indexOfChild(radioButton);

                    Toast.makeText(getApplicationContext(), "service" +index, 500).show();

                    serviceNumber = index+1;

            }
        });

        headerTxt.setText("Pick Services");

        //TODO change color here
        // headerTxt.setBackgroundResource(R.drawable.bg_dialog_header_success);
        // closeLyt.setBackgroundResource(R.color.selector_close_alert_dialog_success);

        closeLyt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        cancelTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        okTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Bundle b = getIntent().getExtras();
                if (b == null)
                    b = new Bundle();
                b.putString("service_id", String.valueOf(serviceNumber));

                Toast.makeText(getApplicationContext(), "service " + String.valueOf(serviceNumber), 500).show();

                //TODO Handle Activity Transition Here
                // startActivity(new Intent(MainActivity.this,
                // Step1.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).putExtras(b));
                // overridePendingTransition(R.anim.push_left_in,
                // R.anim.push_left_out);
            }
        });

        dialog.show();
    }