public String getSubject() throws MessagingException {
    String rawvalue = this.getHeader("Subject", (String)null);
    if (rawvalue == null) {
        return null;
    } else {
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(rawvalue));
        } catch (UnsupportedEncodingException var3) {
            return rawvalue;
        }
    }
}