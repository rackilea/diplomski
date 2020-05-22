@XmlRootElement(name="Levels")
public class Levels {


    private List<Level> levels = new ArrayList<Level>();

    @XmlElementRef(name="Level")
    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}