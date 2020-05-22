private void initTts() {
    tts = new TextToSpeech(this, this);
    tts.setLanguage(Locale.US);
    tts.setOnUtteranceProgressListener(new MyListener());
}

@Override
public void onInit(int status) {
    playSound(0);
}

private void playSound(int index) {
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, String.valueOf(index));
    tts.speak(data.get(index), TextToSpeech.QUEUE_ADD, hashMap);
}

class MyListener extends UtteranceProgressListener {
    @Override
    public void onStart(String utteranceId) {
        int currentIndex = Integer.parseInt(utteranceId);
        mMainAdapter.setCurrentPosition(currentIndex);
        handler.post(new Runnable() {
            @Override
            public void run() {
                mMainAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDone(String utteranceId) {
        int currentIndex = Integer.parseInt(utteranceId);
        mMainAdapter.setCurrentPosition(-1);
        handler.post(new Runnable() {
            @Override
            public void run() {
                mMainAdapter.notifyDataSetChanged();
            }
        });
        if (currentIndex < data.size() - 1) {
            playSound(currentIndex + 1);
        }
    }

    @Override
    public void onError(String utteranceId) {
    }
}