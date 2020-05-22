class User
   {
      String name;
   }

   class Session
   {
      User user;
      Game currentGame;

      void startNextGame()
      {
          //create game, when game end, ask to continue
      }
   }

   class Game
   {
      int ties = 6;
      int number;
      Game()
      {
          Random random = new Random();
          number = random.nextInt();
      }

      void play()
      {
         for( int i = 0; i < tries; ++i )                                                               
         {
             Attempt attempt = new Attempt( number );
             attempt.try();
             if( attempt.guessed() )
             {
                //Show guessed
                return;
             }                                                                                                                                                                               
         }
         //show unguessed   
      }
   }

   class Attempt()
   {
      int expectedNumber;
      Attempt( int number )
      {
         expectedNumber = number;
      }

      void try()
      {
         //get guess
      }

      boolean guessed()
      {
        //return result of try
      }
   }

void main()
{
     //getUser
     User user;
     //if I have session for user, getSession, if not create and store ex. map
    //start next game in session
}