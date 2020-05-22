public class Bookmark
{
    String name,id,nativeUrl,searchUrl;
    int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNativeUrl() {
        return nativeUrl;
    }

    public void setNativeUrl(String nativeUrl) {
        this.nativeUrl = nativeUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", nativeUrl='" + nativeUrl + '\'' +
                ", searchUrl='" + searchUrl + '\'' +
                '}';
    }
}