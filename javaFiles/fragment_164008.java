import java.util.logging.Logger;
import java.util.Arrays;
import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.services.blogger.Blogger;
import com.google.api.services.blogger.Blogger.Blogs.GetByUrl;
import com.google.api.services.blogger.Blogger.Posts.List;
import com.google.api.services.blogger.BloggerScopes;
import com.google.api.services.blogger.model.Blog;
import com.google.api.services.blogger.model.Post;
import com.google.api.services.blogger.model.PostList;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import java.io.IOException;

public class BlogHandler
{
  public Blogger blogger = null;
  public Blog blog;
  public java.util.List<Post> posts;
  public static final Logger log = Logger.getLogger(EngineParseFeed.class.getName());
  static final String API_KEY = "{Your GOOGLE CLOUD API}";

  public BlogHandler() {}

  public void setupService () throws IOException {

    AppIdentityCredential credential = null;
    credential  = new AppIdentityCredential(Arrays.asList(BloggerScopes.BLOGGER)); // Add your scopes here
    this.blogger = new Blogger.Builder(new UrlFetchTransport(), new JacksonFactory(), credential).setApplicationName("trivalAPPName").build();
   }

   public void executeGetBlogByUrl (String url) throws IOException {
     GetByUrl request = blogger.blogs().getByUrl( url );
     this.blog = request.setKey(API_KEY).execute();
     log.info ("Blog" + this.blog);
   }