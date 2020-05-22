private final ArrayList<Position> trail = new ArrayList<>();




public void addNewPosition(Position position){
       trail.add(0, position);       
}

public void removeLastPosition(){
    if (trail.size()> 5) trail.remove(5);
}