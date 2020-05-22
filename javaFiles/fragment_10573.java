protected ArtistInfo(Parcel in) {
    artist = in.readString();

    // Read album info
    albumInfo = new HashMap<>();
    int albumInfoSize = in.readInt();
    for (int i = 0; i < albumInfoSize; i++) {
        String key = in.readString();
        List<Integer> value = new ArrayList<>();
        in.readList(value, null);
        albumInfo.put(key, value);
    }

    // Read song map
    songsMap = new SparseArray<>();
    int songsMapSize = in.readInt();
    for (int i = 0; i < songsMapSize; i++) {
        int key = in.readInt();
        SongInfo value = in.readParcelable(SongInfo.class.getClassLoader());
        songsMap.put(key, value);
    }
}