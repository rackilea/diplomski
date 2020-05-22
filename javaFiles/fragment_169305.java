class Plan
{
    private String planName;
    private String[] columns;

    public Plan(String planName){
        this.planName = planName;
        columns = new String[3];
    }

    public boolean allColumnIsNull(){
        for(String s : columns)
            if(s != null)
                return false;
        return true;
    }

    public void setColumn(String val, int colNum){
        if(colNum >= 0 && colNum < columns.length)
            columns[colNum] = val;
    }

    public String[] getColumns(){
        return columns;
    }

    public String toString(){
        return  (String.format("%-15s", planName) + String.format("%-15s", columns[0]) + 
                 String.format("%-15s", columns[1]) + String.format("%-15s", columns[2]));  
    }
}