titles = "";
lengths = "";
for (int i = 0; i < numOfSongs; i++) {
    if (songTitles[i] != null) {
        titles += songTitles[i] + " ";
        lengths += songLengths[i] + " ";
    }
}