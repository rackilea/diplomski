getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

        @Override
        public void onGlobalLayout() {
            placeButtons();
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    });