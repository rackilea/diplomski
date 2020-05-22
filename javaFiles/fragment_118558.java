private void sortList() {
    List<MyTuple> tuples = new ArrayList<>();

    for (int i = 0; i < Distance.size(); i++) {
        tuples.add(new MyTuple(Distance.get(i), myLat.get(i), 
                                myAlt.get(i), myLon.get(i)));
    }

    Collections.sort(tuples);

    // do something with tuples
}

private class MyTuple implements Comparable<MyTuple> {
    private float distance;
    private float latitude;        
    private float longitude;
    private float altitude;

    public MyTuple(float distance, float altitude, 
                   float latitude, float longitude) {
        this.distance = distance;
        this.latitude = latitude;            
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public int compareTo(MyTuple other) {
        return Float.compare(this.distance, other.distance);
    }
}