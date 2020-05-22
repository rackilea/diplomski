Hashtable<String, Hashtable<String, String>> schedule
    = new Hashtable<String, Hashtable<String, String>>();
schedule.put("A", new Hashtable<String, String>());
schedule.put("B", new Hashtable<String, String>());
schedule.put("C", new Hashtable<String, String>());
schedule.put("D", new Hashtable<String, String>());
schedule.put("E", new Hashtable<String, String>());

schedule.get("A").put("Winter", "M");
schedule.get("A").put("Spring", "tTS");
// Etc...