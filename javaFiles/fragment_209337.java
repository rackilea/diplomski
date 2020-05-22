startbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     if(isRecording){
         stopRecording();
         isRecording=false;
         startbtn.settext("Start Recording")
       }else{
         startRecording();
         isRecording=true;
         startbtn.settext("Stop Recording")
       }

    }
});