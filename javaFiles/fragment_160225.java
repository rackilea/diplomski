public class HexColor implements Comparable<HexColor>{
    private String hexCode;
    private String name;

    //Constructor, getters and setters
...
    public int compareTo(HexColor other){
        return this.hexCode.compareTo(other.hexCode);
    }
}