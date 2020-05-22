public boolean add( Product pr )
{ 
    super.add(pr);
    Collections.sort(this, new Comparator<Product>() {
    @Override
    public int compare(Product p1, Product p2) {
        double f = p1.getPrice();
        double s = p2.getPrice();
        if (f == s) return 0;
        return f<s ? 1 : -1;
    }
   });
   return true;
}