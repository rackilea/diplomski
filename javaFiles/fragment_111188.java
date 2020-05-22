MediaPlayer sounds[] = {sound1, sound2, sound3, sound4};
Random rnd;

public void playSound() {
    // Collect candidates - i.e. those that aren't playing right now.
    List<MediaPlayer> candidates = Arrays.stream(sounds)
            // Only not-playing ones.
            .filter(s -> !s.isPlaying())
            .collect(Collectors.toList());
    // Pick a random one.
    MediaPlayer picked = candidates.get(rnd.nextInt(candidates.size()));
    // Play your sound.

}