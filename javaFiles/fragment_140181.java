ArrayList<ArrayList<Integer>> lists = ArrayList<ArrayList<Integer>>();
int subCounter=0;
lists.add(new ArrayList<Integer>());

for(int i=0; i originalArray.length; i++){

   (if originalArry[i] < 0){

      lists.add(new ArrayList<Integer>());
      subCounter++;

   }
   else{
        lists.get(subCounter).add(originalArry[i]);
   }
}

int[] newArray = new int[oroginalArray.length];

int counter = 0;
for(ArrayList<Integer> list : lists){

    Collections.reverse(list);
   for(int i=0; i < list.size(); i++){

       newArray[counter] = list.get(i);
       counter++;

   }

   newArray[counter] = originalArray[counter]; // add the separator
   counter++;


}