package test;

public class PlayerInfo {

    private String name;
    private Integer score;
    private Integer pictureId;

    public PlayerInfo(final String name, final Integer score, final Integer pictureId) {
        this.name = name;
        this.score = score;
        this.pictureId = pictureId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public Integer getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(final Integer pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.score + ":" + this.pictureId;
    }
}