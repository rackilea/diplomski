import static YoutubeConstants.*;
 @Configuration
 public class YouTubeConfig {

    @Bean
    public YouTube youtube() {
      return new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, request -> {
         }).setApplicationName("youtube-search-demo").build();
    }
 }