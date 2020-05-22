public MyCard1(Context context) {
            super(context, R.layout.home_card_inner_content1);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        TextView mTitleTextView1 = (TextView) parent.findViewById(R.id.home_card_main_inner_title1);
        final TextView mSecondaryTitleTextView1 = (TextView) parent.findViewById(R.id.home_card_main_inner_subtitle1);

            new CountDownTimer(86500000, 1000) { // adjust the milli seconds here

                public void onTick(long millisUntilFinished) {

                    day1 = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                    hour1 = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished));
                    min1 = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished));
                    sec1 = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished));
                    mSecondaryTitleTextView1.setText(day1 + " day, " + hour1 + " hour, " + min1 + " minute, " + sec1 + " second");
                }
                public void onFinish() {mSecondaryTitleTextView1.setText("done!");}
            }.start();

        if (mTitleTextView1 != null)
            mTitleTextView1.setText(mainTitle1);

        if (mSecondaryTitleTextView1 != null)
            mSecondaryTitleTextView1.setText(secondaryTitle1);
    }
}