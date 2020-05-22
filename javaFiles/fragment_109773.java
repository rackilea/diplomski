if((c == '>' || c == '<' || c == '!' || c == '=') && (line.charAt(i + 1) == '='))
{
    sb = new StringBuilder();
    sb.append(c);
    sb.append(line.charAt(i + 1));
    repeatOps(sb.toString());
}
else
{
    sb = new StringBuilder();
    sb.append(c);
    repeatOps(sb.toString());
}