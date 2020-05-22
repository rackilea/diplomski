import java.util.Scanner;

public class Execute 
{
    public static void main( String [] args )
    {   
        // Variables and Objects
        Chatbot bot = new Chatbot();
        Scanner input = new Scanner( System.in );
        String statement = "";

        // Prompt and get the user's first input
        System.out.println( "Type text to start chatting!" );
        statement = input.nextLine();

        // While the user doesn't say goodbye or some other form of it, respond to user and then get their next response
        while( bot.findKeyword( statement, "bye" ) != 1 &&
               bot.findKeyword( statement, "cya" ) != 1 &&
               bot.findKeyword( statement, "goodbye" ) != 1 &&
               bot.findKeyword( statement, "gtg" ) != 1 )
        {
            bot.respond( statement );
            statement = input.nextLine();
        }
        input.close();
        System.out.println( "Goodbye!" );
    }
}