public StringWriter append(char c) {
    write(c);
    return this;
}

public StringWriter append(CharSequence csq) {
    if (csq == null)
        write("null");
    else
        write(csq.toString());
        return this;
}

public StringWriter append(CharSequence csq, int start, int end) {
    CharSequence cs = (csq == null ? "null" : csq);
    write(cs.subSequence(start, end).toString());
        return this;
}