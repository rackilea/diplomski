StringBuilder stringBuilder = new StringBuilder();
for(int i=0; i<strList.size(); i++)
{
    stringBuilder.append(strList.get(i));
    stringBuilder.append(",");
}

// Remove the last character from the StringBuilder to avoid a trailing comma.
String commaSeparatedList = stringBuilder.substring(0, stringBuilder.length() - 1);

out.println(commaSeparatedList);