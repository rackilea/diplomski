class Foo // Rename this!
{
    private double start;
    private double end;
    private boolean flag;

    public void handleValue(double newStart, double newEnd)
    {
        // Insert code here
    }
}

private static void insertFoo(Map<String, Foo> map, String... rooms)
{
    Foo foo = new Foo();
    for (String room : rooms)
    {
        map.put(room, foo);
    }
}

...
HashMap<String, Foo> map = new HashMap<String, Foo>();
insertFoo(map, "FEB 2009", "FEB 2011", ...);
insertFoo(map, "FEB 1130");