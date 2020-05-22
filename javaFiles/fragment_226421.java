public double perimeter() {
    double distance = 0;
    int len = coordinates.size();
    for(int i = 0; i < len; i++) {
         distance += coordinates.get(i).dist(coordinates.get((i+1)%len));
    }
    return distance;
}