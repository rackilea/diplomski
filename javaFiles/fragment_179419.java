public int compareTo(Song s) {
    if (runningTime != s.runningTime) {
        return s.runningTime - runningTime;
    }
    else {
        int lastCmp = title.compareTo(s.title);
        return (lastCmp != 0 ? lastCmp : composer.compareTo(s.composer));
    }
}