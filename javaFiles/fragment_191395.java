public static void main(String[] args) {
    LinkedList<Foo> list = new LinkedList<>(Arrays.asList(
            new Foo("ben", "clock"),
            new Foo("Joe", "paper"),
            new Foo("Joe", "pen"),
            new Foo("Joe", "pencil"),
            new Foo("greg", "couch"),
            new Foo("sam", "desk"),
            new Foo("sam", "book"),
            new Foo("Joe", "earbuds"),
            new Foo("Joe", "sail"),
            new Foo("Joe", "watch")
    ));

    String streakName = null;
    int streakLength = 0;
    String firstData = null;
    String lastData = null;
    for (Foo foo : list) {
        if (! foo.getName().equals(streakName)) {
            if (streakLength != 0)
                processStreak(streakName, streakLength, firstData, lastData);
            streakName = foo.getName();
            streakLength = 0;
            firstData = foo.getData();
        }
        streakLength++;
        lastData = foo.getData();
    }
    if (streakLength != 0)
        processStreak(streakName, streakLength, firstData, lastData);
}
private static void processStreak(String name, int length, String firstData, String lastData) {
    if (length == 1)
        System.out.println("Alone: name=" + name + ", data=" + firstData);
    else
        System.out.println("Repeated: name=" + name + ", first=" + firstData + ", last=" + lastData);
}