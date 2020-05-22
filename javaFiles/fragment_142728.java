public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
    ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

    // We want at least one prediction
    if (predictions.size() > 0) {
        Prediction prediction = predictions.get(0);
        // We want at least some confidence in the result
        if (prediction.score > 1.0) {
            // Show the spell
            Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show();
        }
    }
}