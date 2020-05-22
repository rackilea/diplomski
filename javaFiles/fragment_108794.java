public String positionsRep(TreeSet<Integer> positions){
    StringBuilder s = new StringBuilder("");
    s.append("\"");
    boolean isFirst = true;
    for(Integer pos: positions){
        if (!isFirst) {
            s.append(" ");
        }
        posStr = Integer.toString(pos);
        s.append(posStr);
        isFirst = false;
    }   
    s.append("\"");
    return s.toString();
}