public class Joke {
    private String mText;
    private String mAudio;
    private CATEGORY category;
    private LENGTH length;

    public Joke(String mText, String mAudio, CATEGORY category, LENGTH length) {
        this.mText = mText;
        this.mAudio = mAudio;
        this.category = category;
        this.length = length;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getmAudio() {
        return mAudio;
    }

    public void setmAudio(String mAudio) {
        this.mAudio = mAudio;
    }

    public CATEGORY getCategory() {
        return category;
    }

    public void setCategory(CATEGORY category) {
        this.category = category;
    }

    public LENGTH getLength() {
        return length;
    }

    public void setLength(LENGTH length) {
        this.length = length;
    }
}