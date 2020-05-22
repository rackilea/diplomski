if (mSettings.contains(ALARM_TONE)){
            alarmTone = mSettings.getString(ALARM_TONE, null);
            if (alarmTone != null) {
                uri = Uri.parse(alarmTone);
                //update textview to loaded alarm tone
                TextView t = (TextView) findViewById(R.id.alarmTone);
                t.setText(RingtoneManager.getRingtone(this, uri).getTitle(this));

                mp = MediaPlayer.create(getApplicationContext(), uri);
            }
        }