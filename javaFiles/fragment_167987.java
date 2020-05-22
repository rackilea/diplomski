public class BaseCharacter{
    private String name; //just to have his name
    private int stat1; //to rename later
    private int stat2; //to rename later
    ...
    private int statX; //to rename later

    public BaseCharacter(String name, int stat1, int stat2, ..., int statX){
        this.name = name;
        this.stat1 = stat1;
        this.stat2 = stat2;
        ...
        this.statX = statX;
    }

    // add getter (and setter if the stats can be modify)
}