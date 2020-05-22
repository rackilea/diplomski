public Iterator<MusicTrack> iterator() {
    List<MusicTrack> temp = new ArrayList<MusicTrack>();
    temp.addAll(tracks);
    Collections.sort(temp, new DurationComparator());
    return temp.iterator();
}