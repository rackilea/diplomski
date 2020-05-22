String reverseMe(String s)
{
  if (s.length() == 0)
     return "";
  int index = s.lastIndexOf(" ");
  if (index == -1) // not found, thus just return the string
     return s;
  else // found, thus concat last part with recursive call
     return s.substring(index + 1) + " " + reverseMe(s.substring(0, index));
}