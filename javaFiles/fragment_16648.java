public class ImmediateFileAppender<E> extends RollingFileAppender<E> {

    @Override
    public void openFile(String file_name) throws IOException {
        synchronized (lock) {
            File file = new File(file_name);
            if (FileUtil.isParentDirectoryCreationRequired(file)) {
                boolean result = FileUtil.createMissingParentDirectories(file);
                if (!result) {
                    addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
                }
            }

            ImmediateResilientFileOutputStream resilientFos = new ImmediateResilientFileOutputStream(file, append);
            resilientFos.setContext(context);
            setOutputStream(resilientFos);
        }
    }

    @Override
    protected void writeOut(E event) throws IOException {
        super.writeOut(event);
    }

}