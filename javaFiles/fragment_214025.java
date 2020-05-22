@Override
    public void onAmbientModeChanged(boolean inAmbientMode) {

        super.onAmbientModeChanged(inAmbientMode);
        watchFace.setAntiAlias(!inAmbientMode);

        if(inAmbientMode)
        {
            watchFace.setTimeColor(Color.BLACK);
            watchFace.setDateColor(Color.GREY);
        }
        else
        {
            watchFace.setTimeColor(Color.RED);
            watchFace.setDateColor(Color.WHITE);
        }
    }