SharedPreferences prefs=PreferenceManager.getDefaultSharedreferences(getBaseContext()); 
audioStatus=prefs.getBoolean("AudioPref",true); // (only use true if you want the default to be true if the value has not yet been set, otherwise you should be doing ("AudioPref",false) )

if(!audioStatus) 
{ 
   mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC); 
   mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT); 
}