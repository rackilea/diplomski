public class NthString {

   public static void main(String[] args) {
      Integer n = Integer.parseInt(args[0]);
      Queue<Integer> q = new Queue<Integer>();
      while(!StdIn.isEmpty()){
         q.enqueue(StdIn.readInt());
      }
      while(q.size() > n){
         q.dequeue();
      }
      StdOut.println(q.peek().toString());
   }

}