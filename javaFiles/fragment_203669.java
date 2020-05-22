interface IDirectoryWalkListener {

    void onEnterDirectory(int level, @Nonnull File directory)
            throws IOException;

    void onFile(@Nonnull File file)
            throws IOException;

    void onLeaveDirectory(int level, @Nonnull File directory)
            throws IOException;

}