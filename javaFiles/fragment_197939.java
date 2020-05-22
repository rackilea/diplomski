List results = crit.list();
for (Object item: results) {
   Object[] itemArr = (Object[]) item;
   System.out.println("max: "+ itemArr[0].getClass() +" " + itemArr[0]);
   System.out.println("min: "+ itemArr[1].getClass() +" " + itemArr[1]);
   System.out.println("avg: "+ itemArr[2].getClass() +" " + itemArr[2]);
   System.out.println("count: "+ itemArr[3].getClass() +" " + itemArr[3]);
}