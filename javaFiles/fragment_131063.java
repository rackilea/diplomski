public static SpannableStringBuilder valueOf(CharSequence source) {
    if (source instanceof SpannableStringBuilder) {
        return (SpannableStringBuilder) source;
    } else {
        return new SpannableStringBuilder(source);
    }
}