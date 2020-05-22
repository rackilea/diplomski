public class MyService {

    private SiteDao siteDao;

    public MyService(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    // use the siteDao passed when constructing the object, instead of constructing it
}