@Projection(name = "inlineData", types=Pet.class)
public interface PetProjection{

    Long getId();
    String getName();
    String getDescription();
    List<Media> getMedia();
}