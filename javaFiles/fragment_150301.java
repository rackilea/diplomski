import hsa.Console;
    import java.awt.*;

    public class RickandMorty
    {
      static character rick, morty, summer, jerry;
      static Console c;
      public static void main(String[] args)
      { 
        c = new Console();

        rick = new character();
        rick.selections = 0;
    //    rick.description = ("");

        morty = new character();
           morty.selections = 0;
    //    morty.description = ("");

        summer = new character();
           summer.selections = 0;
    //    summer.description = ("");

        jerry = new character();
           jerry.selections = 0;
    //    jerry.description = ("");


           while(rick.selections <= 5 && morty.selections <= 5 && summer.selections <= 5 && jerry.selections <= 5){

           ask("1. Pick a fear | A Responsibility | B Spiders | C Death | D Being Alone |");
           ask("2. Pick a fear | A Responsibility | B Spiders | C Death | D Being Alone |");
        //.. do this for all your questions. If you want, make an array/arraylist with the questions, and run a loop

        //also, I removed the breaks, because they were redundant. They are already the loop condition





           }


      }
    public static void ask(String q){
           c.print(q);
           String choice = c.readString();
           if (choice.equalsIgnoreCase("A")){
           rick.selections++;
           }
           if (choice.equalsIgnoreCase("B")){
           morty.selections++;
           }
           if (choice.equalsIgnoreCase("C")){
           summer.selections++;
           }
           if (choice.equalsIgnoreCase("D")){
           jerry.selections++;
           }
        }

    }
    class character {
      int selections;
      String descprition;


    }