for (int i = 0; i < formula.size(); i++)
{
  char c = formula.pop();

  if (c == ')')
  {
    right++;
    continue; //You don't need to add this since nothing is being done after this point
  }
  else if (c == '(')
  {
    left++;
    continue; //You don't need to add this since nothing is being done after this point
  }
  //We don't need to do anything if it's neither
}