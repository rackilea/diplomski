//'Classic' method for min price without using complex notions
double min = Double.MAX_VALUE;
//iterate over the prices
for(Double price : products.values()){
    min = Math.min(min, price);
}
System.out.println("min is "+min);

//Second method with Stream (allow to iterate easliy)
double minBis = products.values().stream().min(Comparator.naturalOrder()).get();
System.out.println("mins is "+minBis);