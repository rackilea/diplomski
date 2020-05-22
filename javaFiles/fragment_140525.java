//Create the Data

    List<List<Point>> Llp = new ArrayList<List<Point>>();

    for(int i=0; i< 50; i++)
    {
        List<Point> lp = new ArrayList<Point>();

        for(int j=0; j<50; j++)
        lp.add(new Point((int)(Math.random()*1000), i));

        Llp.add(lp);
    }



    // The comparators
    Comparator<List<Point>> comparator_rows = new Comparator<List<Point>>() {

        @Override
        public int compare(List<Point> o1, List<Point> o2) {
            int i = o2.get(0).y;
            int j = o1.get(0).y;
            if (i < j) {
                return 1;
            } else if (i > j) {
                return -1;
            } else {
                return 0;
            }
        }

    };

    Comparator<Point> comparator_columns = new Comparator<Point>() {

        @Override
        public int compare(Point o1, Point o2) {
            int i = o2.x;
            int j = o1.x;
            if (i < j) {
                return 1;
            } else if (i > j) {
                return -1;
            } else {
                return 0;
            }
        }

    };

    // Sort the rows
    Collections.sort(Llp, comparator_rows);

    // Sort the columns
    for (List<Point> element : Llp) 
        Collections.sort(element, comparator_columns);

    //Print the elements
    int rowIndex = 0, columnIndex=0;

    for (List<Point> row : Llp) 
    {
        for (Point element : row) 
        System.out.print("("+element.x+ "," + element.y +")|");

        System.out.println();
    }