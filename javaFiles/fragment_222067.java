String text = "<p>Hello world</p>";

    // create Spanned
    Spanned spanned = Html.fromHtml(text);
    // create SpannableString
    SpannableString spanString = new SpannableString(spanned);

    // set colored part
    ClickableSpan coloredPart = new ClickableSpan() {
        @Override
        public void onClick(View textView) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.setColor(Color.WHITE);
        }
    };

spanString.setSpan(coloredPart, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

editText.setText(spanString, TextView.BufferType.SPANNABLE);