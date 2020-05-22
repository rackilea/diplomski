@Root
public class AlbumList {
    @ElementList(entry="album", inline=true)
    private List<Child> albums;

    public List<Child> getAlbums() {
        return albums;
    }
}