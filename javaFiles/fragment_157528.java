class MyObject{
    private List<String> lines = new ArrayList<>();

    public void setLine(int lineNumber, String line){
        lines.add(lineNumber,line);
    }

    public String getLine(int lineNumber){
        lines.get(lineNumber);
    }

}