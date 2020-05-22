interface StringEventFactory {
    public static string className();
    public IEvent parseFromArray(string[]);
 };

 class EventNewPlayerFactory implements StringEventFactory
 {
    public static string className() { return "NEWPLAYER"; }

    public IEvent parseFromArray(string[] info) 
    {
        if (info.length != 4) // includes the class name
            return null;

        // sanity check
        if (!info[0].equals(className()) || info[3].isEmpty()) 
            return null;

        int x, y;
        try {
            x = Integer.parseInt(info[1]);
            y = Integer.parseInt(info[2]);
        }
        catch (NumberFormatException ex) {
            // notify?
            return null;
        }

        return new EventNewPlayer(x, y, info[3]);
    }
 };

 // similarly for EventUpdateTime ...

 // main body
 public static void main(string[] args)
 {
    Hashtable<string, StringEventFactory> factories = new Hashtable<string, StringEventFactory>();

    factories.put(EventNewPlayerFactory.className(), new EventNewPlayerFactory());
    // similarly for other classes

    List<IEvent> eventList = new ArrayList();

    // file parsing
    FileReader input = new FileReader(fileName);
    BufferedReader read = new BufferedReader(input);
    String line = null;

    while ((line = read.readLine()) != null)
    {    
        String[] array = line.split(",");
        for (int i = 0; i < array.length; i++)
            array[i] = array[i].trim();

        // fetch the factory class
        StringEventFactory fact = factories.get(array[0]);
        if (fact == null) {
            // class name does not exist
            continue;
        }

        StringEvent out = fact.parseFromArray(array);
        if (out == null) {
            // parameters were incorrect!
            continue;
        }

        // success! add to list
        eventList.add(out);
    }
 }