SpannableString ss = new SpannableString("Hello, how are you ?");
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
         //perform operation on click

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    };
    ss.setSpan(clickableSpan, 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    ss.setSpan(new ForegroundColorSpan(getActivity().getResources().getColor(android.R.color.holo_blue_light)), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    textView_understand.setText(ss);
    textView_understand.setMovementMethod(LinkMovementMethod.getInstance());
    textView_understand.setHighlightColor(Color.TRANSPARENT);
    textView_understand
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //On click
                }
            });