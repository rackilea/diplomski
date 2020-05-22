List<Thread> threads = new ArrayList<>();
String[] names = { "Fred", "Perry", "Dave", "Tom" };
for(String s : names)
{
    threads.add(new Thread(s));
}
Thread greeting = threads.get(0);
Thread greeting1 = threads.get(1);
Thread greeting2 = threads.get(2);
Thread greeting3 = threads.get(3);