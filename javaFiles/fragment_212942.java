import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type movieListType = new TypeToken<List<Movie>>() {}.getType();
    List<Movie> movies = gson.fromJson(new FileReader("input.json"), movieListType);

    // movies has just one Movie
    Movie movie = movies.get(0);

    // Find the first two Backdrop URLs with size = w1280
    int foundCount = 0;
    for (Backdrop backdrop : movie.backdrops)
    {
      if ("w1280".equals(backdrop.image.size))
      {
        System.out.println("URL Found: " + backdrop.image.url);
        foundCount++;
        if (foundCount == 2)
        {
          break;
        }
      }
    }
  }
}

class Movie
{
  int id;
  String name;
  List<Poster> posters;
  List<Backdrop> backdrops;
}

class Poster
{
  Image image;
}

class Backdrop
{
  Image image;
}

class Image
{
  String type;
  String size;
  int height;
  int width;
  String url;
  String id;
}