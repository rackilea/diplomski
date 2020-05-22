public String toString() {
    try {
        return this.toString(0);
    } catch (Exception e) {
        return null;
    }
}

public String toString(int indentFactor) throws JSONException {
    StringWriter w = new StringWriter();
    synchronized (w.getBuffer()) {
        return this.write(w, indentFactor, 0).toString();
    }
}

public Writer write(Writer writer) throws JSONException {
    return this.write(writer, 0, 0);
}