private Button getTouchedButton(MotionEvent event) {
        for(int i=0; i<myGridView.getChildCount(); i++) {
            Rect buttonRect = new Rect()
            Button child = (Button)mGridView.getChildAt(i);
            child.getHitRect(buttonRect)
            if (child.contains(Math.round(event.rawX), Math.round(event.rawY))){
                return child;
            }
        }
        return null;
    }