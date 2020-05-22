for(int i = 0; i < generatedSequenceToPlay.size(); i++){
        final int position = i;
        _handler.postDelayed(new Runnable() {
            @Override
            public synchronized void run() {
                findButtonById(_defuseButtonHandler.getKeyByValue(generatedSequenceToPlay.get(position).toString())).setPressed(true);
            }
        }, 500 + i * 100);
        _handler.postDelayed(new Runnable() {
            @Override
            public synchronized void run() {
                findButtonById(_defuseButtonHandler.getKeyByValue(generatedSequenceToPlay.get(position).toString())).setPressed(false);

            }
        }, 500 + i * 100);
    }