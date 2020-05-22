public boolean add( Product pr )
{ 
    return super.add(pr);
    Collections.sort(this, new Comparator<Product>() { // unreachable
    @Override
    public int compare(Product p1, Product p2) {
        double f = p1.getPrice();
        double s = p2.getPrice();
        if (f == s) return 0;
        return f<s ? 1 : -1;
    }
   });
}