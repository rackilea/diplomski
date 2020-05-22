@UiThread
public static void setClickable(@NonNull TextView tv, 
                                @NonNull SpannableString ss, 
                                int start, int end, 
                                @NonNull final Context from, @NonNull final Class to){

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            from.startActivity(new Intent(from, to));
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    };
    ss.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    ss.setSpan(new StyleSpan(Typeface.ITALIC), start, end, 0);
    tv.setText(ss);
    tv.setMovementMethod(LinkMovementMethod.getInstance());
    tv.setHighlightColor(Color.TRANSPARENT);
}