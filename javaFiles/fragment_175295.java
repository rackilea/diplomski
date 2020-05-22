for (int i = 1; i < 7; i++) {
        //draw black lines
        canvas.drawLine((mSideRectWidth/2) + boxWidth * i, 0, mSideRectWidth + boxWidth * i, getHeight(), mBackPaint);
    }

    for (int i = 0; i < 7; i++) {
        //draw text views
        canvas.drawText(Integer.toString(i + 1), (mSideRectWidth / 2) + (i * boxWidth) + (boxWidth / 2), ((canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2)), mTextPaint);
    }