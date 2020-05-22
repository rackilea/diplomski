import java.io.Serializable;
import java.util.List;

public class ElementStruct implements Serializable {
    private int artistId;
    private List<Object> features;

    public ElementStruct(int artistId, List<Object> features) {
        this.artistId = artistId;
        this.features = features;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public List<Object> getFeatures() {
        return features;
    }

    public void setFeatures(List<Object> features) {
        this.features = features;
    }
}