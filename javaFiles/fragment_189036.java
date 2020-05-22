String [] alphabet ={"A","B","C","A","E","A","A" };
ArrayList<Integer> list = new ArrayList<Integer>();
for (int i=0;i<alphabet.length;i++) {
   if (alphabet[i].equals("A")) {
    list.add(i);
   }
  }
System.out.println(list);
 }