class FileFilterWrapper {

    private final FileFilter innerFilter;

    public FileFilterWrapper(FileFilter innerFilter) {
        this.innerFilter = innerFilter;
    }

    @Override
    public String toString(){
        // Use innerFilter properties to produce the desired String
        return ...
    }
}