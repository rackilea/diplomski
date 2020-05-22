if (movies.isEmpty()) {
    movies.add(new Dvd(userMovie), movies.length()+1);
} else if (!movies.isEmpty()) {
    boolean found = false;
    for (int i = 1; i <= movies.length(); i++) {
        if (movies.get(i).getTitle().equals(userMovie)) {   
            movies.get(i).addCopy();
            found = true;
        }
    }
    if (!found) {
        movies.add(new Dvd(userMovie), movies.length()+1);
    }
}