@Override
    protected void onPause() {
        super.onPause();
        if(myLocationOverlay!=null){
            myLocationOverlay.disableMyLocation();
            myLocationOverlay.disableCompass();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(myLocationOverlay!=null){
            **myLocationOverlay.disableLocation();**
            myLocationOverlay.disableCompass();
        }
    }