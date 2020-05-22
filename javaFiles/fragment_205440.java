CompoundDirectory exif = (CompoundDirectory) new TIFFReader().read(input);
List<Directory> ifds = new ArrayList<>;

for (int i = 0; i < exif.directoryCount(); i++) {
    List<Entry> entries = new ArrayList<>();

    for (Entry entry : exif.getDirectory(i)) {
        entries.add(entry);
    }

    // TODO: Do stuff with entries, remove, add, change, etc...

    ifds.add(new IFD(entries));
}

// Write Exif
new TIFFWriter().write(new TIFFDirectory(ifds), output);