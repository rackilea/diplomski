public class News {

    @PropertyName("title")
    public String mtitle;

    @PropertyName("description")
    public String mDesc;

    public News(String title, String desc) {
        mtitle = title;
        mdesc = desc;
    }
}