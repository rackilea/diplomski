private void writeText(String text) {
    int length = text.length();
    for (int i = 0; i < length; i++) {
        char c = text.charAt(i);
        switch (c) {
            case '\0':
                this.writer.write(NULL);
                break;
            case '&':
                this.writer.write(AMP);
                break;
            case '<':
                this.writer.write(LT);
                break;
            case '>':
                this.writer.write(GT);
                break;
            case '"':
                this.writer.write(QUOT);
                break;
            case '\'':
                this.writer.write(APOS);
                break;
            case '\r':
                this.writer.write(SLASH_R);
                break;
            default:
                this.writer.write(c);
        }
    }
}