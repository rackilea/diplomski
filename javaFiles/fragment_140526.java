//Create the Data

        List<List<Point>> Llp = new ArrayList<List<Point>>();

        for(int i=0; i< 50; i++)
        {
            List<Point> lp = new ArrayList<Point>();

            for(int j=0; j<50; j++)
            lp.add(new Point((int)(Math.random()*1000), (int)(Math.random()*1000)));

            Llp.add(lp);
        }


        //If all data is mixed up we need to filter into new rows based on X using a TreeMap

        TreeMap<Integer, TreeMap<Integer,Point>> data = new TreeMap<Integer,TreeMap<Integer,Point>>();

        for (List<Point> row : Llp) 
        {
            for (Point element : row) 
            {
                TreeMap<Integer,Point> rowForX;
                if(data.containsKey(element.x))
                    rowForX = data.get(element.x);
                else
                    data.put(element.x, rowForX = new TreeMap<Integer,Point>());    
                    //Create specific row in TreeMap

                rowForX.put(element.y,element);
            }           
        }


        //Convert Sorted TreeMap(s) to Lists

        Llp.clear();
        Iterator<Entry<Integer, TreeMap<Integer, Point>>> it = data.entrySet().iterator();

        while(it.hasNext())
            Llp.add(new ArrayList<Point>(it.next().getValue().values()));


        //Print the elements
        int rowIndex = 0, columnIndex=0;

        for (List<Point> row : Llp) 
        {
            for (Point element : row) 
            System.out.print("("+element.x+ "," + element.y +")|");

            System.out.println();
        }