public class  IndirectedComparator implements Comparator<Integer> {


   private Integer[] array;
   private Integer[] index;

   public IndirectedComparator(Integer [] array, Integer[] index){
      this.array = array;

      this.index = new Integer[index.length];
      System.arraycopy(index, 0, this.index, 0, index.length);
   }

   @Override
   public int compare(Integer i1, Integer i2) {
      return Integer.compare(array[index[i1]], array[index[i2]]);
   }

}