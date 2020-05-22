final SpannableStringBuilder builder = new SpannableStringBuilder(username)
        .append(" ")
        .append(text)
        .setSpan(new ForegroundColorSpan(Color.parseColor("#bdbdbd")),
                0 /* startIndex */,
                username.length() /* endIndex */,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE /* flags */);

commentText1.setText(builder);