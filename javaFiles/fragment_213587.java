for (String i : list) {
    System.out.println(i);
    list.remove(i); // throws exception
} 

Iterator it=list.iterator();
while (it.hasNext()){
    System.out.println(it.next());
    it.remove(); // valid here
}