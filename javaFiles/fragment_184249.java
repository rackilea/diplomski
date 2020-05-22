Iterator<Object[]> it = carsWithDetails.iterator();
while(it.hasNext()){
  Object[] car = (Object[]) it.next();
  System.out.println("Car Details:  ");
  System.out.println("Id: "+car[0]);
  System.out.println("Name: "+car[1]);
  System.out.println("Price: "+car[2]);
  System.out.println("Type: "+car[3]);
}