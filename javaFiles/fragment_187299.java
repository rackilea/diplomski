String str = "{[(1;1;2),(5;1;2),(5;1;1)],[(1;3;2),(5;3;2),(5;1;2)]}";

    Pattern pattern = Pattern.compile("(\\(\\d;\\d;\\d\\),?){3}");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
        int i = 1;
        System.out.println("Polygon Coordinates: ");
        String[] coordinates = matcher.group(0).split(",");

        for (String point: coordinates) {
            System.out.println("Coordinate " + (i++) + ": " + point);

            point = point.replace("\\(", "").replace("\\)", "");
            String[] s3 = point.split(";");
            tp.add(new Point(Double.valueOf(s3[0]), Double.valueOf(s3[1]),
                             Double.valueOf(s3[2])));

        }

        sf.add(new Surface((Point[]) tp.toArray()));
        System.out.println();
    }