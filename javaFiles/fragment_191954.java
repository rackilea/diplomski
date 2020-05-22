@Override
public String toString() {
    String result = " ";
    for (int i = 0; i < this.size(); i++) {
        result += " " + this.get(i);
    }
    return result;
}