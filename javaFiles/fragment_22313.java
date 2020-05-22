public Optional<Track> getTrack(int id) {
  for (Track track : tracks) {
    if (track.getId() == id) {
      return Optional.of(track);
    }
  }
  return Optional.empty()
}