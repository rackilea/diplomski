List<Song> list; // all songs
int n; // provided by user

TreeSet<Song> set = new TreeSet<Song>(new Comparator() ...);
for (int i = 0; i < n; i++) {
    set.add(list.get(i));
}

Song max = set.last();
for (int i = n; i < list.size(); i++) {
    Song song = list.get(i);
    if (song.qi < max.qi) {
        set.remove(max);
        set.add(song);
        max = set.last();
    }
}