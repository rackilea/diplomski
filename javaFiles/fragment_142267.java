private String vote(int choice)
{
  if(choice == 1)
  {
    candidate1Votes++;
  }
  else if(choice == 2)
  {
    candidate2Votes++;
  }
  else
  {
    return "invalid choice, no vote cast";
  }
  return "your vote has been cast";
}