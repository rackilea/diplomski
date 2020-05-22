@Override
public int getChildCount(Object parent) {
    int count = 0;
    if (parent instanceof java.io.File && ((java.io.File) parent).canRead()) {
        count = fileModel.getFilteredFiles().size();
    }
    return count;
}