String s ="(220 616) (220 666) (251 670) (272 647)";
    String[] arr = s.split("\\)\\s*");
    List<Point> points = new ArrayList<Point>();
    for (String anArr : arr){
        int x = Integer.parseInt(anArr.substring(1,anArr.indexOf(" ")));
        int y = Integer.parseInt(anArr.substring(anArr.indexOf(" ") + 1, anArr.length()));
        Point p = new Point(x,y);
        points.add(p);
        System.out.println(p);
    }