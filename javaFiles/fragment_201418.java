if(availableWidth > 0.0F) {
            updateDrawText = this.mCurrentTextSize != newTextSize;
            this.mCurrentTextSize = newTextSize;
        }

        if(this.mTextToDraw == null || updateDrawText) {
            this.mTextPaint.setTextSize(this.mCurrentTextSize);
            CharSequence title = TextUtils.ellipsize(this.mText, this.mTextPaint, availableWidth, TruncateAt.END);
            if(this.mTextToDraw == null || !this.mTextToDraw.equals(title)) {
                this.mTextToDraw = title;
            }

            this.mTextWidth = this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length());
        }