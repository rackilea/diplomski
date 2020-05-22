class GameEntry {
    // Other stuff
    ...

    @Overwrite
    public String toString() {
        return "GameEntry[score=" + scores + "]";
    }
}