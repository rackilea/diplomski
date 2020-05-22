import java.util.Scanner;
public class ChatbotClient
{
   public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);

       Chatbot t = new Chatbot();
       System.out.print("What is your name? ");
       String name = input.nextLine();

       System.out.println(t.introbot());

       System.out.print(name + "> ");
       String reply = input.nextLine();

      while (!reply.equalsIgnoreCase("quit")){
        System.out.println(t.getName() + "> " + t.getreply(reply));
        System.out.print(name + "> ");
        reply = input.nextLine();
      }
     }
}