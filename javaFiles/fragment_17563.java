public class ListViewItem {
    public int ThumbnailResource;
    public String Title;
    public String Description;

    @Override
    public String toString(){
        return Title;
    }
}