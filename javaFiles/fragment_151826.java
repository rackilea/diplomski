public class GenerateMovieThumbnailsURL {
  final static String BASE_MOVIE_THUMBNAIL_URL = "https://image.tmdb.org/t/p/";

  final static String imageQuality = "w185";
  String imageURL;

  GenerateMovieThumbnailsURL(String imageExtendedURI) {
    imageURL = imageExtendedURI;
  }

public static URL buildURL(String imageLink) {

    Uri builtURI = Uri.parse(BASE_MOVIE_THUMBNAIL_URL).buildUpon()
            .appendPath(imageQuality)
            .appendEncodedPath(imageLink)
            .build();


    URL url = null;
    try {
        url = new URL(builtURI.toString());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }

    return url;

  }
}