@XmlRootElement(name = "BUILDING")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Level.class })
public class Building {

    @XmlElement(name = "LEVEL")
    private Level levels[];

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Building [levels=" + Arrays.toString(levels) + "]";
    }

}