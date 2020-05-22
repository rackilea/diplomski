public static void main(String[] args) {
   String reply;
   HashMap<String, String> map = new HashMap<>();
   System.out.println("Type 0 to end.");
   do {
       Scanner input = new Scanner(System.in);
       System.out.println("<==Enter your question here==>");
       System.out.print("You: ");
       reply = input.nextLine();
       if (!reply.equals("0")){

          if (map.containsKey(reply))               // if question has already been stored
               System.out.println(map.get(reply));  // print the answer
          else {

               System.out.println("Enter your answer ==>");
               System.out.print("You: ");
               map.put(reply, input.nextLine());         // add pair question/answer
          }
        }else{
                System.out.println("<==End==>");
        }
   } while (!reply.equals("0"));
}