List<Integer> myCoords = new ArrayList<Integer>();
myCoords.add(10);
myCoords.add(20);
myCoords.add(30);
myCoords.add(40);
myCoords.add(50);
Iterator<Integer> myListIterator = myCoords.iterator(); 
while (myListIterator.hasNext()) {
    Integer coord = myListIterator.next();     
    System.out.print("\r");
    System.out.print(coord);
    Thread.sleep(2000);
}