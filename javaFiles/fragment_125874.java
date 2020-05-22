Class QuitReducerException extends InterruptedException {

      //Parameterless Constructor
      public QuitReducerException() {}

      //Constructor that accepts a message
      public QuitReducerException(String message)
      {
         super(message);
      }
}