public String display() {
    String total = "Name: ";
    for (int i = 0; i < item.length; i++) {
        total += item[i].getName();
    }
    return total;
}