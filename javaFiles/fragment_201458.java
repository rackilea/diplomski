public static void ChangeActivity(View target, final Activity currentActivity, final Class<?> nextActivity){

        target.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(currentActivity, nextActivity);
                currentActivity.startActivity(intent);  
                currentActivity.overridePendingTransition(R.drawable.push_down_in,R.drawable.push_down_out);
            }
        });

    }