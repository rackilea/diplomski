StringBuilder sb = new StringBuilder();
for (String s : input)
{
    sb.append("s").append(delimiter);
}

if (sb.toString().endsWith(delimiter))
{
    sb.deleteCharAt(sb.length()-1);
}
System.out.println(sb.toString());
// Results in output: s,s,s