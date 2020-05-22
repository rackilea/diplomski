public boolean stop(int id) {
    if (clips.get(id-1) != null) {
        clips.get(id-1).stop();
        return true;
    }
    return false;
}