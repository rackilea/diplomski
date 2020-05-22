@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(artist);

    // Write album info
    dest.writeInt(albumInfo.size());
    for (Map.Entry<String, List<Integer>> item : albumInfo.entrySet()) {
        dest.writeString(item.getKey());
        dest.writeList(item.getValue());
    }

    // Write song map
    dest.writeInt(songsMap.size());
    for (int i = 0; i < songsMap.size(); i++) {
        int key = songsMap.keyAt(i);
        dest.writeInt(key);
        dest.writeParcelable(songsMap.get(key), flags);
    }
}