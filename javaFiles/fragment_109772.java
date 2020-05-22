if((c == '>' || c == '<' || c == '!' || c == '=') && (line.charAt(i + 1) == '='))
{
    sb.append(c);
    sb.append(line.charAt(i + 1));
    str = sb.toString();
    repeatOps(str);
}
else
{
    sb.append(c);
    str = sb.toString();
    repeatOps(str);
}