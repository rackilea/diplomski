myprefs=context.getSharedPreferences("myprefs",001);
    final  SharedPreferences.Editor prefseditor=myprefs.edit();


    try{   

        switch(state)
        {
        case TelephonyManager.CALL_STATE_IDLE:
           { 
               try
           {
               Log.d("DEBUG", "IDLE");        
               StopRecording();  
           }
           catch (Exception e) {  
            // TODO: handle exception
        }

              break;
           }

        case TelephonyManager.CALL_STATE_RINGING:
           {
               prefseditor.putString("in",incomingNumber);
                prefseditor.commit();
               Log.d("DEBUG", "RINGING");
               StopRecording();
               break;
           }
        case TelephonyManager.CALL_STATE_OFFHOOK:
           {

               no1=myprefs.getString("in", "nothing");
                System.out.println("INCOMING"+no1);

                Log.d("DEBUG", "OFFHOOK");      


                String aa="15555215556";
                 if(aa.equals(no1)){

                 StartRecording();
                 break;
             }
           }
        }

    }
       catch (Exception e) {
            // TODO: handle exception
        }


    super.onCallStateChanged(state, incomingNumber);
}
private void StartRecording() {
    // TODO Auto-generated method stub

    try{



 recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
 recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
 recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
 recorder.setOutputFile(this.getFullSdPath());
 recorder.prepare();


 recorder.start();   // Recording is now started
    Log.i(this.getClass().getName(), "Start Recording");


    }
    catch (Exception e) {
        // TODO: handle exception
    }
    //db.execSQL("DROP TABLE IF EXISTS incomingnumber");
}
public String getFullSdPath(){
    File sdCard = new File(Environment.getExternalStorageDirectory()    + "/.RecordMyVoice");
     if (!sdCard.exists()) {
       sdCard.mkdir();
     }
     File file = new File(Environment.getExternalStorageDirectory()     +"/.RecordMyVoice/",new Date().getTime()+".mp3");
     System.out.println("Full path of record sound is : "+file.getAbsolutePath());
     return file.getAbsolutePath();
 }           


private void StopRecording() {
    // TODO Auto-generated method stub
    recorder.stop();          
    recorder.release();
    recorder = null;
    Log.i(this.getClass().getName(), "Stop Recording");
}