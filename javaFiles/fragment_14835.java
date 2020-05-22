@Service
 public class YouTubeApiService {
    @Autowired
    private YouTube youtube;

     public List<SearchResult> searchYouTube(String searchQuery) {
         List<SearchResult> searchResults =
            executeSearch(searchQuery,youtube);
         //etc...
     }
 }