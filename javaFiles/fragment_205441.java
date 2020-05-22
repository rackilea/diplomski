public final class MutableDirectory extends AbstractDirectory {
    public MutableDirectory (final Collection<? extends Entry> entries) {
        super(entries);
    }

    public boolean isReadOnly() {
        return false;
    }

    // NOTE: While the above is all you need to make it *mutable*, 
    // TIFF/Exif does not allow entries with duplicate IDs, 
    // you need to handle this somehow. The below code is untested...
    @Override
    public boolean add(Entry entry) {
        Entry existing = getEntryById(entry.getIdentifier());

        if (existing != null) {
            remove(existing);
        }

        super.add(entry);
    }
}