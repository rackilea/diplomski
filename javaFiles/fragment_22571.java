String text = "X2";
SuperscriptSpan superscriptSpan = new SuperscriptSpan();
SpannableStringBuilder builder = new SpannableStringBuilder(text);
builder.setSpan(
                superscriptSpan,
                text.indexOf("2"),
                text.indexOf("2") + String.valueOf("2").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

yourTextView.setText(builder);