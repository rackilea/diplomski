public class Item implements Comparable<Item>{

private int number;

public Item(int number) {
    this.number = number;
}

public int getNumber() {
    return number;
}


public void setNumber(int number) {
    this.number = number;
}


public int compareTo(Item o) {
    //sort increasing
    //return  this.getNumber() - o.getNumber();

    //sort decreasing
    return o.getNumber() - this.number;
    }
}