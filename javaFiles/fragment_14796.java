import java.util.*;

class Subsets {

 public static List<List<Integer>> findSubsets(int[] nums){
 List<List<Integer>> result = new ArrayList<>();

 Queue<List<Integer>> queue = new LinkedList<>();
 queue.add(new ArrayList<>()); // add empty set to queue
 result.add(new ArrayList<>()); //add empty set to result

 for(int i=0; i<nums.length; i++){

     while(!queue.isEmpty()){
        System.out.println("current result = " + result);

        List<Integer> temp = queue.poll();
        System.out.println("current temp = " + temp);

        System.out.println("before change temp, current result = " + result);

        temp.add(nums[i]);
        System.out.println(i + " add index i value to temp, i= " + temp);
        System.out.println("not yet add to result, current result = " + result);

        result.add(temp);
        System.out.println("after add temp to result, result = " + result);
      }

      //add copy of all elements in result to queue
      int j=0;
      while(j < result.size()){
      queue.add(new ArrayList<>(result.get(j)));
      j++;
     }
  }
  return result;
}


 public static void main(String[] args) {
   List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
   System.out.println("Here is the list of subsets: " + result);
 }
}