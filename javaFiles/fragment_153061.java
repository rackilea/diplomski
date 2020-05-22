public class FeedType {

private Bitmap profilePicSrc;
private String name;
private FeedContent feedContent;
private Context context;
private final String PIC_BASE_SRC = "xxx";
private final String PIC_END_SRC = "xxx";


public FeedType(String contactId, String name, FeedContent feedContent, Context context){
    try {
        this.profilePicSrc = BitmapFactory.decodeStream((InputStream)new URL(PIC_BASE_SRC + contactId.toString() + PIC_END_SRC).getContent());
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    this.name = name;
    this.context = context;
    this.feedContent = feedContent;
}

public String getName(){
    return name;
}

public Bitmap getProfilePicture(){
    return profilePicSrc;
}

public FeedContent getContent(){
    return this.feedContent;
}