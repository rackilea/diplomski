List<NameFileCount> nfcs = new ArrayList<>();
for (int i = 0; i < names.size(); i++) {
    NameFileCount nfc = new NameFileCount(
        names.get(i),
        files.get(i),
        counts.get(i)
    );
    nfcs.add(nfc);
}