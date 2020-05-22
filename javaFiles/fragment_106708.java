import com.models.pageTitle;

public class HeaderComponent{
    public String headerMeta;
    public String keywords;
    private BasePageTitle bpt = new BasePageTitle();

    // this is the constructor - which is used to create instances of this class
    // and (mostly) to initialize object variables 
    public HeaderComponent(){
       headerMeta = "Page Title" + bpt.getPageTitle();    
       keywords = "Description" + bpt.getPageTitle();
    }

}