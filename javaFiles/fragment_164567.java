public class NewsList {

@SerializedName("status")
@Expose
private String status;
@SerializedName("articles")
@Expose
private List<Article> articles = null;
// getter setter
}