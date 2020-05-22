for (int i = 0; i < formula.size(); i++)
{
  char c = formula.pop();
  switch(c)
  {
    case '(':
      left++;
      break; //Which breaks the switch, not the for
    case ')':
      right++;
      break;
    //We don't need to do anything if it's neither. 
  }
}