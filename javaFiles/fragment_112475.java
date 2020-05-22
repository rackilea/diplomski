public static final String footballStr = "football";
public static final String joggingStr = "jogging";

private Map<String, LinkedList> sports = new HashMap<>();
{
    sports.put(footballStr, new LinkedList());
    sports.put(joggingStr, new LinkedList());
}

public LinkedList getSportsByInput(String key)
{
    if (sports.containsKey(key))
    {
        LinkedList ll = sports.get(key);

        //...
    }
}