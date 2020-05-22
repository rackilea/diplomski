import java.util.Scanner;

class CodeEntry
{
     private Scanner scanner = new Scanner(System.in);
     private String entryMessage;
     private int guessCount;
     private String secretValue;

     public CodeEntry(String entryMessage, int guessCount, String secretValue, String WrongCodeMessage, String RightCodeMessage, String OutOfAttemptsMessage)
     {
         this.scanner = scanner;
         this.entryMessage = entryMessage;
         this.guessCount = guessCount;
         this.secretValue = secretValue;

         this.WrongCodeMessage = WrongCodeMessage;
         this.RightCodeMessage = RightCodeMessage;
         this.OutOfAttemptsMessage = OutOfAttemptsMessage;
     }

     private String getAttemptString(int attempt)
     {
         return "Attempt " + (attempt + 1) + "/" + guessCount;
     }

     private String WrongCodeMessage;
     private String RightCodeMessage;
     private String OutOfAttemptsMessage;

     public boolean EnterCode()
     {
          boolean guessed = false;

          for (int attempt = 0; attempt < guessCount; attempt++)
          {
              System.out.println(entryMessage);
              guessed = secretValue.equals(scanner.next());

              if (guessed)
              {
                  System.out.println(RightCodeMessage);
                  break;
              }

              System.out.println(WrongCodeMessage + " " + getAttemptString(attempt));
          }

          if (!guessed)
          {
              System.out.println(OutOfAttemptsMessage);
          }

         return guessed;
    }
}

public class MyClass {
    public static void main(String args[]) {
        CodeEntry pinEntry = new CodeEntry("Enter your PIN", 3, "12345", "Wrong PIN, try again.", "PIN Correct. SIM Unlocked", "PIN Blocked");
        if (!pinEntry.EnterCode())
        {
            CodeEntry pukEntry = new CodeEntry("Enter your PUK", 3, "123456789", "Wrong PUK, try again.", "PUK Correct. SIM Unlocked", "SIM Blocked");
            if (!pukEntry.EnterCode())
            {
                //badjuju - if needed
            }
        }
    }
}