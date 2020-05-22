playlistPos++;

if (playlistPos == myUris.size()) {
    playlistPos = 0;
}

initSong(myUris.get(playlistPos));