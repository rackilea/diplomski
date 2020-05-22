List<Album> albums = new ArrayList<Album>();
String artistName = "", albumName = "";
ArrayList<String> albumTracks;

while (inFile.hasNextLine()) {
    Scanner inLine = new Scanner(inFile.nextLine());
    if(inLine.hasNext()) artistName = inLine.next();
    if(inLine.hasNext()) albumName = inLine.next();
    albumTracks = new ArrayList<>();

    while (inLine.hasNext()) {
        albumTracks.add(inLine.next());
    }

    albums.add(new Album(artistName, albumName, albumTracks));
}