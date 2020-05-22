import java.util.*;

public class Algorithm {

    static List<List<Integer>> getChildren(List<Integer> node){
        List<List<Integer>> children = new ArrayList<List<Integer>>();
        for(int i = 0; i < 6; i++){
            List<Integer> child = new ArrayList<Integer>(node);
            child.add(i);
            children.add(child);
        }
        return children;
    }

    static List<Integer> find(Queue<List<Integer>> queue, Set<List<Integer>> set){

        for(;;){
            List<Integer> head = queue.poll();
            if(!set.contains(head)){
                return head;
            } else {
                for(List<Integer> child : getChildren(head)){
                    queue.add(child);
                }
            }
        }
    }

    public static void main(String[] arg) {
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        for(int i = 0; i < 6; i++){
            queue.add(Collections.singletonList(i));
        }
        // Example {{0},{1},{2},{3},{4},{5},{0,1},{0,2},{0,3},{0,5},...}
        Set<List<Integer>> task = new HashSet<List<Integer>>();
        task.add(Arrays.asList(0));
        task.add(Arrays.asList(1));
        task.add(Arrays.asList(2));
        task.add(Arrays.asList(3));
        task.add(Arrays.asList(4));
        task.add(Arrays.asList(5));
        task.add(Arrays.asList(0, 1));
        task.add(Arrays.asList(0, 2));
        task.add(Arrays.asList(0, 3));
        task.add(Arrays.asList(0, 5));

        System.out.println(find(queue, task));
    }

}