@Retention(RUNTIME)
@JsonQualifier
public @interface Wrapped {
}

public class VideosJsonConverter {
  @Wrapped @FromJson
  public List<Video> fromJson(VideosResponse json) {
    return json.results;
  }

  @ToJson
  public VideosResponse toJson(@Wrapped List<Video> value) {
    throw new UnsupportedOperationException();
  }
}

@GET("3/movie/{id}/videos")
@Wrapped
Call<List<Video>> movieVideos(
  @Path("id") int id,
  @Query("api_key") String apiKey);