public class Response {

    private List<Wall> wall;

    public List<Wall> getWall() { return this.wall; }

    public void setWall(List<Wall> wall) {  this.wall = wall; }

    @Override
    public String toString() { return "Response [wall=" + wall + "]"; }
}