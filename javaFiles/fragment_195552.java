public List getTokens() {
    if ( p == -1 ) {
        fillBuffer();
    }
    return tokens;
}

protected void fillBuffer() {
    // fill `tokens`
}