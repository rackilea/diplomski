while((line=in.readline()) != null)
{
    String temp = line.trim();
    if (temp.isEmpty() || temp.startsWith("#"))
        /* ignore line */;
    else
        ...
}