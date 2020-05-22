> recorder = new MediaRecorder();               
>               recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_DOWNLINK + MediaRecorder.AudioSource.VOICE_UPLINK);//test using the addition sign
> for both DOWNLINK + UPLINK
>               recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
>               recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);                
>               myFileName = getFilename();
>               recorder.setOutputFile(myFileName);