public String replace(CharSequence target, CharSequence replacement) {
   return Pattern
            .compile(target.toString(), Pattern.LITERAL)
            .matcher(this )
            .replaceAll(
                    Matcher.quoteReplacement(replacement.toString()));
}