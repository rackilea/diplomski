class Fruit implements Comparable<Fruit> {
protected int number;
protected String name;

public Fruits(int number, String name) {
    this.number = number;
    this.name = name;
}

@Override
public int compareTo(Fruit f) {
    return number < f.number;
    // or depending on if ascending or descending order wanted
    // return number > f.number 
}
}