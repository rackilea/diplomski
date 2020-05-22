private boolean isMarqueed(TextView tv){
        return isMarqueed(tv.getText().toString(), mPhoneNumberTextView.getWidth(), mPhoneNumberTextView);
    }

    private boolean isMarqueed(String text, int textWidth, TextView tv) {
        Paint testPaint = new Paint();
        testPaint.set(tv.getPaint());
        boolean isMarquee = true;
        if (textWidth > 0) {
            int availableWidth = (int) (textWidth - tv.getPaddingLeft() - tv.getPaddingRight()-testPaint.measureText(text));
            if(availableWidth > 0)
                isMarquee = false;
        }
        return isMarquee;
    }