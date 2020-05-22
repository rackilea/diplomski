ArrayList list = new ArrayList();

 Iterator<RetailerNames > retaileriterator = retailerNamesList.iterator();

while(retaileriterator.hasNext()){
 id=retaileriterator .next().getmRetailerid();
 System.out.println(id);
  list.add(id);
   }
 System.out.println(list);