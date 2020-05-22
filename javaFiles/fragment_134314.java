public static List<String> withHello(List<String> items)
{
    List<String> newList = new ArrayList<String>(items);
    newList.add("Hello");
    return newList;
}