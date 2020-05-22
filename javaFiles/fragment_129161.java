Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher("(100,200),(300,400)");

    ArrayList<Integer> values = new ArrayList<>();
    while(m.find())
        values.add(Integer.parseInt(m.group()));

    ArrayList<Point> points = new ArrayList<>();
    if(values.size() % 2 == 0)
        for(int i = 0; i < values.size(); i += 2)
            points.add(new Point(values.get(i), values.get(i + 1)));

    for(Point point : points)
        System.out.println(point.x + ", " + point.y);