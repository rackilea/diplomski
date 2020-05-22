public class Permutation   {
    public static List<List<Integer>> calculate(List<List<Integer>> input) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();//

        if (input.isEmpty()) {  // If input is an empty list
            result.add(new ArrayList<Integer>());// then add empty list to the resultand return
            return result;
        } else {//here we have a non-empty list to process
            List<Integer> head = input.get(0);//get the first list as a head
            List<List<Integer>> tail= calculate(input.subList(1, input.size()));//recursion to calculate a tail list to calculate a tail list
            for (Integer h : head) {//we merge every head element with every tail list
                for (List<Integer> t : tail) {
                    List<Integer> resultElement= new ArrayList<Integer>();//here is a new element of our result list
                    resultElement.add(h);//firstly, add the head element to this tmp list
                    resultElement.addAll(t);//add all the element from the tail list
                    result.add(resultElement);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> bigList=Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6));
        System.out.println(calculate(bigList));
    }
}