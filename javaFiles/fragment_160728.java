class DurationComparator implements Comparator<MusicTrack> {

    @Override
    public int compare(MusicTrack o1, MusicTrack o2) {
        int d1 = o1 == null ? 0 : o1.getDuration();
        int d2 = o2 == null ? 0 : o2.getDuration();
        return d2 - d1;
    }
}