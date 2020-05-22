class MyObject{
    private Map<Integer,String> lines = new HashMap<>();

    public void setLine(int lineNumber, String line){
        lines.put(lineNumber,line);
    }

    public String getLine(int lineNumber){
        lines.get(lineNumber);
    }

}