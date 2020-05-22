string[] teams = {"Boston","San Francisco","Red Sox","Giants"};
for (string home:teams) 
{
  for (string away:teams) 
  {
     if (home==away) continue;
     System.out.println(home + " x " + away);
  }
}