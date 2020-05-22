public class Article {

@SerializedName("source")
@Expose
private Source source;
@SerializedName("author")
@Expose
private String author;
@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("url")
@Expose
private String url;
@SerializedName("urlToImage")
@Expose
private String urlToImage;
@SerializedName("publishedAt")
@Expose
private String publishedAt;
// your getter setter methods
}