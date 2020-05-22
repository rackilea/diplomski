public static String toUnicode(String text)
{
 if (text == null || text.isEmpty())
{
  return "";
}
StringBuilder unicodeTextArrayString = new StringBuilder();
for (int i = 0; i < text.length(); i++)
{
  char ch = text.charAt(i);
  if (ch < 0x10)
  {
    unicodeTextArrayString.append("\\u000" + Integer.toHexString(ch));
  }
  else if (ch < 0x100)
  {
    unicodeTextArrayString.append("\\u00" + Integer.toHexString(ch));
  }
  else if (ch < 0x1000)
  {
    unicodeTextArrayString.append("\\u0" + Integer.toHexString(ch));
  }
  else
  {
    unicodeTextArrayString.append("\\u" + Integer.toHexString(ch));
  }
}

return unicodeTextArrayString.toString();
}