/** For selecting an alarmtone */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ALARM_URI:
                    uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                    TextView mTextView = (TextView) findViewById(R.id.alarmTone);
                    mTextView.setText(RingtoneManager.getRingtone(this, uri).getTitle(this));

                    mp = new MediaPlayer();
                    mp = MediaPlayer.create(getApplicationContext(), uri);

                    mp.setLooping(true);

                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(ALARM_TONE, uri.toString());
                    editor.commit();

                    break;

                default:
                    break;
            }
        }
    }