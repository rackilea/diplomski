public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
        if(!this.usingReader) {
            B2CConverter.getCharset(enc);
            this.coyoteRequest.setCharacterEncoding(enc);
        }
    }