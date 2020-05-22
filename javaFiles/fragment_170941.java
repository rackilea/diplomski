@Override
public void onClick(View v) {
    switch(v.getId())
    {
        case R.id.btn_speak:
            mTTS.speak(speakButton.getText().toString(), TextToSpeech.QUEUE_ADD, null);
        break;
        case R.id.btn_about:
            mTTS.speak(infoButton.getText().toString(), TextToSpeech.QUEUE_ADD, null);
        break;
        case R.id.btn_voice:
            mTTS.speak(voiceButton.getText().toString(), TextToSpeech.QUEUE_ADD, null);
        break;
    }

}