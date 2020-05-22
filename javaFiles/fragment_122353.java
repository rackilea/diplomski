RelativeLayout mainParent = (RelativeLayout) getParent();
        final RelativeLayout child = (RelativeLayout) getChildAt(0);
        child.measure(MeasureSpec.makeMeasureSpec((mainParent.getWidth() / 2) - 30, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec((mainParent.getHeight() / 2) - 30, MeasureSpec.EXACTLY));
        Log.d("SAMPLE", "RelativeLayout Child childcount: " + child.getChildCount());
        for (int i = 0; i < child.getChildCount(); i++) {
            Log.d("SAMPLE", "In loop: " + i);
            final View childOfChild = child.getChildAt(i);
            childOfChild.measure(MeasureSpec.makeMeasureSpec((mainParent.getWidth() / 2) - 30, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(200, MeasureSpec.AT_MOST));
        }