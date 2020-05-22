public class Package {
    List<Pack> myList = new ArrayList<Pack>();
    Pack obj;
    double total = 0;

    public double addPackage(int type, double num) {
        if (type == 1) {
            obj = new Pack(type, num);
            total = obj.calculateTotal();
        } else {
            obj = new Pack(type, num);
            total = obj.calculateTotal();
        }
        myList.add(obj);
        return total;
    }

    public int listSize() {
        return myList.size();
    }
}