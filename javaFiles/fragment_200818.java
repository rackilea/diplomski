Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
    i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
    i.putExtra(AlarmClock.EXTRA_HOUR, hour);
    i.putExtra(AlarmClock.EXTRA_MINUTES, minute);
    i.putExtra(AlarmClock.EXTRA_MESSAGE, "Good Morning");
    startActivity(i);