public interface OnDrawViewListener {
        void onStartDrawing();

        void onEndDrawing();

        void onClearDrawing();

        void onRequestText();

        void onMove(MotionEvent motionEvent); // added this method
    }