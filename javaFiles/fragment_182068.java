import java.lang.reflect.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class tweetfeedreader {
  public static void main(String args[]) throws IOException {
    Gson gson = new Gson();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(
            "jsonfile.json"));
    String line;
    StringBuilder sb = new StringBuilder();
    while ((line = bufferedReader.readLine()) != null) sb.append(line);
    Type tweetCollection = new TypeToken<Collection<tweet>>(){}.getType();
    Collection<tweet> tweets = gson.fromJson(line, tweetCollection);
    for (final tweet t : tweets) System.out.println(t.text);
  }
}