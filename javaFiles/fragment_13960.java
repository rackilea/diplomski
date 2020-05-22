public static void main(final String... args)
{
    final Memento<String> memento = new Memento<String>();

    memento.set("state1");
    System.out.println(memento.lastEntered()); // "state1"
    memento.persist();
    memento.set("state2");
    System.out.println(memento.lastEntered()); // "state2"
    System.out.println(memento.lastSaved()); // "state1"
}