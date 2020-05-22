private static class WorkPair{

  public final List<String> so_far;
  public final List<String> left;
  public WorkPair(List<String> sf,List<String> l){
    so_far=sf;left=l;
  }

}

public static List<List<String>> combinationsIterative(List<String> strings)
{

    Queue<WorkPair> queue = new LinkedList<WorkPair>();

        // setup queue
        for(String str : strings){
           List<String> so_far = new ArrayList<String>(Arrays.asList(str));
           List<String> left = new ArrayList<String>(strings);
           left.remove(str);
           queue.add(new WorkPair(so_far,left));
        }

        // collect the results
        List<List<String>> result = new ArrayList<List<String>>();            
        while(!queue.isEmpty()){
          WorkPair pair = queue.remove();
          // at each stage add the list so_far
          List<String> so_far_add = new ArrayList<String>(pair.so_far);
          result.add(so_far_add);

          // if there's more work to be done create more workpairs
          if(pair.left.size()>0){
            // push work items for so_far + one element of left
            for(String str : pair.left){
                   List<String> so_far = new ArrayList<String>(pair.so_far);
                   so_far.add(str);
                   List<String> left = new ArrayList<String>(pair.left);
                   left.remove(str);
                   queue.add(new WorkPair(so_far,left));      
            }
          }

        }

    return result;
}