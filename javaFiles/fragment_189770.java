public static String listToString(Node first)
{
    if(first == null) return "";
    String result = first.text;
    return result + " " + listToString(first.next);
}