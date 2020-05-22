Uri soundPath = Uri.parse("uri_link_for_mp3");
RingtoneManager.setActualDefaultRingtoneUri(getApplicationContext(), 
        RingtoneManager.TYPE_RINGTONE, soundPath);

Uri ringtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), ringtone);
r.play();