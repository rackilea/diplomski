final Writer out = new OutputStreamWriter(System.out) {
    @Override
    public void close() {
        // do not close System.out
    }
};
final JsonWriter jsonWriter = new JsonWriter(out);
jsonWriter.setIndent("\t");
DirectoryWalk.walk(root, ToFlatJsonArrayDirectoryWalkListener.get(jsonWriter));
out.flush();