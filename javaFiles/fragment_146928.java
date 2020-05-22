SpannableString ss = new SpannableString(" Hello, @John how's going on");
ClickableSpan clickableSpan = new ClickableSpan() {
   @Override
   public void onClick(View textView) {
     //perform click operation
   }
   @Override
   public void updateDrawState(TextPaint ds) {

   }
};

ss.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

yourTv.setText(ss);
yourTv.setMovementMethod(LinkMovementMethod.getInstance());
yourTv.setHighlightColor(Color.TRANSPARENT);