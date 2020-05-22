if (fromServer.equals("Bye."))
     break;

if (LOCAL_JOKE_STATE == 0)
{
   out.println("Who's there?");
   LOCAL_JOKE_STATE = 1;
}
else if (LOCAL_JOKE_STATE == 1)
{
   out.println(fromServer + " who?");
   LOCAL_JOKE_STATE = 2;
}
else
{
   out.println("y"); // get another joke
   LOCAL_JOKE_STATE = 0;
}