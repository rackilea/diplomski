List<Market> a1 = new ArrayList<>();
List<RetailShop> a2 = new ArrayList<>();

//Adding Market
al.add(m1);
al.add(m2);
al.add(m3);
al.add(m4);
al.add(m5);
//Adding RetailShop

a2.add(rt1);
a2.add(rt2);
a3.add(rt3);

for(Market mt:a1){
   System.out.println(mt.billamount);
   System.out.println(mt.customer);
   System.out.println(mt.invoiceno);
}
for(RetailShop rts:a2){
   System.out.println(rts.custName);
}