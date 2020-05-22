public void mouseDraw(Point[] segments, int time) {
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

        Path path = new Path();
        path.moveTo(segments[0].x, segments[0].y);

        for (int i = 1; i < segments.length; i++) {

            path.lineTo(segments[i].x, segments[i].y);

            GestureDescription.StrokeDescription sd = new GestureDescription.StrokeDescription(path, 0, time);

            dispatchGesture(new GestureDescription.Builder().addStroke(sd).build(), new AccessibilityService.GestureResultCallback() {

                @Override
                public void onCompleted(GestureDescription gestureDescription) {
                    super.onCompleted(gestureDescription);
                }

                @Override
                public void onCancelled(GestureDescription gestureDescription) {
                    super.onCancelled(gestureDescription);
                }
            }, null);
        }
    }
}