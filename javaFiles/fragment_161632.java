MapProperty<String, Object> master = new SimpleMapProperty<String, Object>(
        FXCollections.observableMap(new HashMap<String, Object>()));
MapProperty<String, Object> child = new SimpleMapProperty<String, Object>(
        FXCollections.observableMap(new HashMap<String, Object>()));

child.bindContent(master);

master.put("k1", "v1");

System.out.println("Java version: " + System.getProperty("java.version"));
System.out.println("OS version  : " + System.getProperty("os.name") + " - " + System.getProperty("os.arch"));
System.out.println("------------");
System.out.println("master: " + master);
System.out.println("child : " + child);

child.unbindContent(master);
child.clear();

System.out.println("------------");
System.out.println("master: " + master);
System.out.println("child : " + child);

child.put("k2", "v2");

System.out.println("------------");
System.out.println("master: " + master);
System.out.println("child : " + child);