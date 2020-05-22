public boolean hasPoint(Point p){

    for (int i=0; i<this.points.size(); i++){
        if (points.get(i).equals(p)){
            return true; 
        }
    }

    return false;     
}