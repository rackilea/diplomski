public void playSpecificSong(String specificSong) {
    String nextSong = songQueue.remove();
    while (!nextSong.equals(specificSong) && !songQueue.isEmpty()) {
        nextSong = songQueue.remove();
    }

    if (nextSong.equals(specificSong)) {
        // specific song was found in the queue and is held within the nextSong variable
        // songQueue now contains all songs AFTER specificSong and nothing before
    } else {
        // specific song wasn't found in the queue
        // songQueue is now empty
    }
}