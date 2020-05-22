final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle("Verify Phone Number");
builder.setMessage("An sms will be sent to the number " + phNo + " for verification. Charges will apply as per your plan");
builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                //code to send sms here with the code value
                final ProgressDialog progressdialog = ProgressDialog.show(getActivity(), "Waiting for SMS", "Please hold on");

                final CountDownTimer timer = new CountDownTimer(120000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    Log.v("ranjapp", "Ticking " + millisUntilFinished / 1000);
                     progressdialog.setMessage("Waiting for the message " + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                     getActivity().unregisterReceiver(receiver);
                     progressdialog.dismiss();

                    }
                }.start();

                receiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Bundle bundle = intent.getExtras();
                        if (bundle != null) {
                            if (readSMS(intent, code)) {
                                Log.v("ranjapp", "SMS read");
                                timer.cancel();
                                try {
                                    getActivity().unregisterReceiver(receiver);
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                };
     getActivity().registerReceiver(receiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
            }
        }

);
builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()

        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }

);
builder.show();