Map<String, LinkedHashMap<String, Integer>> orderInfo = new LinkedHashMap<>();

    while (userScanner.hasNextLine()) {
        String line = userScanner.nextLine();
         // To-Do : check regx
        String[] columns = line.split("\\t");

        String userId = columns[0];
        String productId = columns[1];
        int order = Integer.parseInt(columns[2]);
        LinkedHashMap<String, Integer> prodMap = orderInfo.get(userId);
        if (prodMap == null || prodMap.isEmpty()) {
            prodMap = new LinkedHashMap<String, Integer>();
        }
        prodMap.put(productId, new Integer(order));
        orderInfo.put(userId, prodMap);
    }

    int[][] matrix =  new int[orderInfo.size()][];
    int row = 0 ;

    // dictionary will contain Name as a key and belonging row as a value 
    Map<String,Integer> dictionary = new HashMap<String,Integer>();

    for (Entry<String, LinkedHashMap<String, Integer>> entry : orderInfo.entrySet())
    {
        dictionary.put(entry.getKey(), row);
        matrix[row] = new int[entry.getValue().size()];
        int columns = 0;
        for(Entry<String, Integer> ent : entry.getValue().entrySet())  
        {
            matrix[row][columns] = ent.getValue();
            columns = columns + 1;
        }
        row = row + 1;
    }

    for (int rw = 0; rw < matrix.length; rw++) {
        for (int col = 0; col < matrix[rw].length; col++) {
            System.out.print(matrix[rw][col]+"    ");
        }
        System.out.println();
     }

    System.out.println(dictionary);