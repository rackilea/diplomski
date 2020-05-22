@Root(strict = false)
public class ImagesList {

    @ElementList(entry = "imageList", inline = true)
    private List<String> images;

    public List<String> getImages() {
        return images;
    }
}