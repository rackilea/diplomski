ViewAlbum album = new ViewAlbum();
// ...

while (resultSet.next()) {
    album.setAlbumid(resultSet.getInt("albumid"));
    // ...
    allAlbums.add(album);
}