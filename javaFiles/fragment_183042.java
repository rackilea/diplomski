public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("myJson.json"));
        Gson gson = new Gson();
        MoviesContainer movie = gson.fromJson(br, MoviesContainer.class);
        List<AbridgedCastData> movies = movie.movies;
        System.out.println(movies);
    }
}

class MoviesContainer {
    @SerializedName("abridged_cast")
    public List<AbridgedCastData> movies;
}

class AbridgedCastData {
    String name;
    String id;
    List<String> characters;
    @Override
    public String toString() {
        return "AbridgedCastData [name=" + name + ", id=" + id
                + ", characters=" + characters + "]";
    }    
}