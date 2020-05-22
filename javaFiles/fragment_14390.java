public int read(byte[] b, int off, int len) {
    if deflater finished:
        return -1
    if deflater needs input:
        get next string from iterator
        deflater.setInput(s.getBytes("UTF-8"))
        if iterator at end:
            deflater.finish()
    deflate into b using off and len
}