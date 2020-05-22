public void setActivity(ImageView activityNum, int activity) {
    switch (activity) {
        case 1:
            activityNum.setImageResource(R.drawable.hello);
            activityNum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // handle the click here
                    Hello(v);
                }
            });
            break;
        case 2: etc...
    }
}