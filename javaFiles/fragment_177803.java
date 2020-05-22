List<? extends Number> l = new ArrayList<>();
List<PositiveInteger> p = new ArrayList<PositiveInteger>();
p.add(new PositiveInteger(10));
l = p;
Object ni = l.get(0);
if(ni instanceof NegativeInteger){
   NegativeInteger tmp = (NegativeInteger)ni;
   System.out.println(ni);
}