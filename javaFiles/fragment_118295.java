import java.io.Serializable;

public class Recommendation implements Serializable {
    private int artistId;
    private int userId;

    public Recommendation(int artistId, int userId){
        this.artistId = artistId;
        this.userId = userId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}