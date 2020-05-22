if (this.filename != null) {
    if (this.charset == null || StandardCharsets.US_ASCII.equals(this.charset)) {
        sb.append("; filename=\"");
        sb.append(this.filename).append('\"');
    }
    else {
        sb.append("; filename*=");
        sb.append(encodeHeaderFieldParam(this.filename, this.charset));
    }
}