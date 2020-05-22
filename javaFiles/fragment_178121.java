List firstList = new ArrayList();
firstList.add("one");
firstList.add("two");
firstList.add("three");

List secondList = new ArrayList();
secondList.add("four");
secondList.add("five");
secondList.add("six");

Iterator itr = firstList.listIterator();
while(itr.hasNext()){
    String tempString1 = (String)itr.next();
    Iterator iter = secondList.listIterator();
    while(iter.hasNext()){
        String trmpString2 = (String)iter.next();
         itr.set(trmpString2);    // Change the element the iterator is currently at
       // tempString1 = trmpString2;
        break;
    }
    break;
}
System.out.println(firstList);