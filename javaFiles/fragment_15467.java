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