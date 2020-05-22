case MotionEvent.ACTION_MOVE: {
            // If we cross the touch slop, don't perform the delayed peek for an edge touch.
            if (mLeftDragger.checkTouchSlop(ViewDragHelper.DIRECTION_ALL)) {
                mLeftCallback.removeCallbacks();
                mRightCallback.removeCallbacks();
            }
            break;
        }