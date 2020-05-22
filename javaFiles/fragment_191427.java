public final class DiacriticFilter extends TokenFilter {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    @Override
    public final boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            String result = stripDiacritics(new String(termAtt.buffer()));
            char[] newBuffer = result.toCharArray();
            termAtt.copyBuffer(newBuffer, 0, newBuffer.length)
            termAtt.setLength(newBuffer.length);
            return true;
        } else {
            return false;
        }
    }

    private static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }
}