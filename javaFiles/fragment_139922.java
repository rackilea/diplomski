private List<Track> tracks;
private IdTracker idTracker;

public void addTrack(Track track) {
    long id = idTracker.getNextId();
    track.setId(id);
    this.tracks.add(track);
}

public void removeTrack(Track track) {
    if (tracks.contains(track)) {
        this.tracks.remove(track);
        this.idTracker.removeId(track.getId());
    } else {
        Terminal.printError("track with id " + track.getId() + " doesn't exist.");
        }
    }