// Collect candidates - i.e. those that aren't playing right now.
    List<MediaPlayer> candidates = new ArrayList<>();
    for ( int i = 0; i < sounds.length; i++) {
        if ( !sounds[i].isPlaying() ) {
            candidates.add(sounds[i]);
        }
    }