public static String getMonth(int monthNumber)
{
  if (monthNumber < 1 || monthNumber > 12) {
    return "ERROR " + monthNumber + " is less then 1 (or greater then 12)";
  }
  int monthNameLength = 10;
  int end = monthNumber * monthNameLength;
  int start = end - monthNameLength;
  return monthNames.substring(start, end);
}