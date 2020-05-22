public class Chemical {

    private String chemName;
    private String chemFreezingPoint;
    private String chemBoilingPoint;
    private String chemUnitNumbers;


    public Chemical(String name, String freezingPoint, String boilingPoint, String unitNumbers){
    chemName = name;
    chemFreezingPoint = freezingPoint;
    chemBoilingPoint = boilingPoint;
    chemUnitNumbers = unitNumbers;
    }


    //String[][] chemArray = new String [5][4];
    String[][] chemArray = {{"Ethanol","-173","172","1575"},{"Oxygen","-363","-306","1000"},{"Water","32","212","5000"},
                            {"Benzene","41.9","176.2","2750"},{"Ethylene Glycol","8.78","378","1900"}};

     public String toString(){
        return // Return the string in the format you want here... 
     }

}