public class myComperator implements Comparator<Product<?>> {
    @Override
    public int compare(Product<?> o1, Product<?> o2) {
        if (o1.getName().length() > o2.getName().length())
            return 1;
        else if (o1.getName().length() < o2.getName().length())
            return -1;
        else
            return -1;
    }
}