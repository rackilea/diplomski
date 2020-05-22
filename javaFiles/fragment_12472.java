public List<DVD> search(String titleToFind) {
    List<DVD> matches = new ArrayList<DVD>();    
    for (DVD dvdEntry : DVDlist) {
        if (dvdEntry.GetTitle().equalsIgnoreCase(titleToFind)) {
            matches.add(dvdEntry);
        }
    }

    return matches;
}