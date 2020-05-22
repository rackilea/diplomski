final class ToFlatJsonArrayDirectoryWalkListener
        implements IDirectoryWalkListener {

    private final JsonWriter jsonWriter;

    private ToFlatJsonArrayDirectoryWalkListener(final JsonWriter jsonWriter) {
        this.jsonWriter = jsonWriter;
    }

    static IDirectoryWalkListener get(final JsonWriter jsonWriter) {
        return new ToFlatJsonArrayDirectoryWalkListener(jsonWriter);
    }

    @Override
    public void onEnterDirectory(final int level, @Nonnull final File directory)
            throws IOException {
        if ( level == 0 ) {
            jsonWriter.beginArray();
        }
        jsonWriter.value(directory.getPath());
    }

    @Override
    public void onFile(@Nonnull final File file)
            throws IOException {
        jsonWriter.value(file.getPath());
    }

    @Override
    public void onLeaveDirectory(final int level, @Nonnull final File directory)
            throws IOException {
        if ( level == 0 ) {
            jsonWriter.endArray();
        }
    }

}