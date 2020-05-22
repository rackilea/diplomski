private void setLedValue(boolean value) {
    try {
        mLedGpio.setValue(!mLedGpio.getValue());
    } catch (IOException e) {
        Log.e(TAG, "Error updating GPIO value", e);
    }
}