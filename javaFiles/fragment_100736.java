@Path("/news")
public class NewsResource {

    NewsService newsService = new NewsService();

    @GET
    public List<News> getNews(@PathParam("countryId") int countryId){
        if(countryId==null){
            return newsService.getNews();
        }else{
            return newsService.getCountryNews(countryId);
        }
    }

}