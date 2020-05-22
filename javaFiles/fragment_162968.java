ManhattanDistance manhattan = new ManhattanDistance();
    try {
        kmeans.setDistanceFunction(manhattan);
    } catch (Exception e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }