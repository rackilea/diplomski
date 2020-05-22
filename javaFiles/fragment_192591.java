String myString = "ASADASAD"; // or "AAAAAAAAAA"
String stringToFind = "ASAD"; // or "AAA"

int offset = 0;
int count = 0;
while (offset < myString.length())
{
  int index = myString.indexOf(stringToFind, offset);
  if (index < 0)
    break;
  count++;
  offset = index + 1;
}