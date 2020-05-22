/**
     * Construct an InternetAddress given the address and personal name.
     * The address is assumed to be a syntactically valid RFC822 address.
     *
     * @param address   the address in RFC822 format
     * @param personal  the personal name
     * @param charset   the MIME charset for the name
     * @exception   UnsupportedEncodingException if the personal name
     *          can't be encoded in the given charset
     */
    public InternetAddress(String address, String personal, String charset)
                throws UnsupportedEncodingException {
    this.address = address;
    setPersonal(personal, charset);
    }