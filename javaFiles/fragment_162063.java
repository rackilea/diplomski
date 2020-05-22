class Range{
    private int start, end;
    public Range(int st, int en){
        start = st;
        end = en;
    }

    @Override
    public String toString(){
        return "Range(" +start+ ", " +end+ ")";
    }
}