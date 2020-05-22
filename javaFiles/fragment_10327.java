Collections.sort(highscoreList, new Comparator<>() {
    @Override
    public int compare(Highscore h1,Highscore h2) {
        return h2.getPoints() - h1.getPoints();
    }
});