String reverse(String s)
{
  String reversed = "";
  String[] split = s.split(" ");
  reversed = split[split.length-1];
  for (int i = split.length-2; i >= 0; i--)
  {
    reversed += " " + split[i];
  }
  return reversed;
}