private void writeField(String field) {
    if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
        writeQuoted(field);
    else
        printStream.print(field);
}