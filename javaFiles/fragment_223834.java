List<Object[]> arr = new ArrayList<Object[]>();

   for (int i = 0; i < 26; i++)
   {
       Object obj[] = {capital[i], count[i]}; //add the capital and count to the List
       arr.add(obj);
   }

   Collections.sort(arr, new Comparator<Object[]>() {
        public int compare(Object[] c1, Object[] c2) {
            return (int)c2[1] - (int)c1[1]; // will sort the count in decending order
        }
    });

   for(int i = 0; i < arr.size(); i++)
       System.out.println( "CAPITAL: " + (char)arr.get(i)[0] + " "+ "COUNT: " + (int)arr.get(i)[1]); //print all the content


 }