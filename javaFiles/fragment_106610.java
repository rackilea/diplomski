public abstract class Sort {
protected int[] lst;

public Sort(int[] lst) {
    this.lst = lst;
}

public abstract void sort();

public String toString() {
    String aa = "";
    for (int innt : this.lst) {
        aa = aa + innt + "" + " ";
    }
    return aa;
}
}