class Cup<T extends Number> implements Comparable<T> {
    ...
    public double getVolume(){
        return radius.doubleValue() * radius.doubleValue() 
               height.doubleValue() * Math.PI;
    }