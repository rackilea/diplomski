SharedPreferences pref = getApplicationContext().getSharedPreferences("timer2stringpref", MODE_PRIVATE);
    Bundle timer2extras = getIntent().getExtras();
    if (timer2extras != null) {
        String timer2string = timer2extras.getString("timer2string");
        starttimer = Integer.parseInt(timer2string);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("value", starttimer);
        editor.apply();

    } else {
        int starttimerx = pref.getInt("value", 0);
        starttimer = starttimerx;
    }