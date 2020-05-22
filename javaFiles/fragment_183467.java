public String encodeHTML(String s)
{
    s = s.replaceAll("#", "%23");
    s = s.replaceAll("%", "%25");
    return s;
}