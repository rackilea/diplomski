public static List<Album> getMissingAlbums(List<Album> currentAlbums) {
    List<Album> missingAlbums = new ArrayList<>();

    for (Album currAlbum : currentAlbums) {
        if (currAlbum.status.equals("MISSING")) {
            missingAlbums.add(currAlbum);
        }
    }

    return missingAlbums;
}