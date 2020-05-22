case MotionEvent.ACTION_UP:
        if (!mScrolling) {
            endSelectionMode();
            //
            // Fixes 4.4 double selection
            // See: http://stackoverflow.com/questions/20391783/how-to-avoid-default-selection-on-long-press-in-android-kitkat-4-4
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                return false;
            }
        }
        mScrollDiffX = 0;
        mScrollDiffY = 0;
        mScrolling = false;
        //
        // Fixes 4.4 double selection
        // See: http://stackoverflow.com/questions/20391783/how-to-avoid-default-selection-on-long-press-in-android-kitkat-4-4
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && isInSelectionMode()) {
            return true;
        }
        break;