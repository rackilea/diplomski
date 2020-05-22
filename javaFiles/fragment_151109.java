void writeChar(char c) {
    if (this.len >= this.buf.length) {
        flushBuffer();
    }
    this.buf[(this.len++)] = c;
}