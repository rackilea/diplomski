class CheckListException extends Exception
{
      //Parameterless Constructor
      public CheckListException() {}

      //Constructor that accepts a message
      public CheckListException(List list)
      {
         super(list);
      }
 }