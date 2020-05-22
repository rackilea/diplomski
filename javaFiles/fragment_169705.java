query1.whereEqualTo("phone", "0644444444");
query1.getFirstInBackground(new GetCallback<ParseObject>() 
{
  public void done(ParseObject object, ParseException e) 
  {
    if(e == null)
    {
     //object exists
    }
    else
    {
      if(e.getCode() == ParseException.OBJECT_NOT_FOUND)
      {
       //object doesn't exist
      }
      else
      {
      //unknown error, debug
      }
     }
  }
});