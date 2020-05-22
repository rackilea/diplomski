// ...

while (resultSet.next()) {
    ViewAlbum album = new ViewAlbum();
    album.setAlbumid(resultSet.getInt("albumid"));
    // ...
    allAlbums.add(album);
}