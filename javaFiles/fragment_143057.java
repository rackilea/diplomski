public void aggregate() throws Exception
  {
    BufferedReader bigFile = new BufferedReader(new FileReader("path/to/file.csv"));

    // Notice the paramter for initial capacity. Use something that is large enough to prevent rehashings.
    Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>(500000);

    while (bigFile.ready())
    {
      String line = bigFile.readLine();
      int lastTab = line.lastIndexOf('\t');
      String firstFourColumns = line.substring(0, lastTab);

      // See if the map already contains an entry for the first 4 columns
      HashSet<String> set = map.get(firstFourColumns);

      // If set is null, then the map hasn't seen these columns before
      if (set==null)
      {
        // Make a new Set (for aggregation), and add it to the map
        set = new HashSet<String>();
        map.put(firstFourColumns, set);
      }

      // At this point we either found set or created it ourselves
      String lastColumn = line.substring(lastTab+1);
      set.add(lastColumn);
    }
    bigFile.close();

    // A demo that shows how to iterate over the map and set structures
    for (Map.Entry<String, HashSet<String>> entry : map.entrySet())
    {
      String firstFourColumns = entry.getKey();
      System.out.print(firstFourColumns + "=");

      HashSet<String> aggregatedLastColumns = entry.getValue();
      for (String column : aggregatedLastColumns)
      {
        System.out.print(column + ",");
      }
      System.out.println("");
    }
  }