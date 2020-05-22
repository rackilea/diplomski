public class StoriesResponse extends JsonModel{
private static final long serialVersionUID = -2329376390030680204L;

@SerializedName("stories")
private List<StoryAbstract> storyAbstracts;

public List<StoryAbstract> getStoryAbstracts() {
    return storyAbstracts;
}

public void setStoryAbstracts(List<StoryAbstract> storyAbstracts) {
    this.storyAbstracts = storyAbstracts;
}