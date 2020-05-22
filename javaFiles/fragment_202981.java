@XmlRootElement(name="Level")
public class Level {

    private Solution solution = new Solution();
    private Clues clues = new Clues();

    @XmlElementRef(name="Solution")
    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @XmlElementRef(name="Clues")
    public Clues getClues() {
        return clues;
    }

    public void setClues(Clues clues) {
        this.clues = clues;
    }
}