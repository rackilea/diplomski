public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
    ArrayList<Prediction> predictions = gestures.recognize(gesture);
    if (predictions == null || predictions.isEmpty()) {
        return;
    }
    // continue the regular flow
}