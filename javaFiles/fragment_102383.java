public class SearchNode {
    private int xCoordinate;
    private int yCoordinate;
    private double gScore;
    private double hScore;

    public double getfScore() {
        return gScore + hScore;
    }

    public double getgScore() {
        return gScore;
    }

    public void setgScore(int gScore) {
        this.gScore = gScore;
    }


    public SearchNode(int xCoordinate,int yCoordinate, double gScore, SearchNode endNode) {
        this.gScore=gScore;
        this.hScore = //Manhattan distance from this node to end node
        this.xCoordinate =xCoordinate;
        this.yCoordinate = yCoordinate;
    }

   public int getxCoordinate() {
       return xCoordinate;
   }

   public int getyCoordinate() {
       return yCoordinate;
   }
}