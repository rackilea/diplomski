class MyObject {
    private String userId;
    private FavTracks favTracks;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FavTracks getFavTracks() {
        return favTracks;
    }

    public void setFavTracks(FavTracks favTracks) {
        this.favTracks = favTracks;
    }
}

class FavTracks {
    private String favourite;
    private String unFavourite;

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getUnFavourite() {
        return unFavourite;
    }

    public void setUnFavourite(String unFavourite) {
        this.unFavourite = unFavourite;
    }
}