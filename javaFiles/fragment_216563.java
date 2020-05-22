float xMin, xMax, yMin, yMax, zMin, zMax;
    xMin = yMin = zMin = Float.MAX_VALUE;
    xMax = yMax = zMax = Float.MIN_VALUE;

    while ((line = meshReader.readLine()) != null) {
        String[] tokens = line.split(" ");
        tokens = Util.RemoveEmptyStrings(tokens);

        if (tokens.length == 0 || tokens[0].equals("#") ||
                tokens[0].equals("vt") || tokens[0].equals("vn") || tokens[0].equals("f"))
            continue;
        else if (tokens[0].equals("v")) {
            xVertices = Float.parseFloat(tokens[1]);
            yVertices = Float.parseFloat(tokens[2]);
            zVertices = Float.parseFloat(tokens[3]);

            if (xMin > xVertices) xMin = xVertices;
            if (yMin > yVertices) yMin = yVertices;
            if (zMin > zVertices) zMin = zVertices;

            if (xMax < xVertices) xMax = xVertices;
            if (yMax < yVertices) yMax = yVertices;
            if (zMax < zVertices) zMax = zVertices;

            System.out.println("xVertices:" + xVertices);
            System.out.println("yVertices:" + yVertices);
            System.out.println("zVertices:" + zVertices);

            // get min/max x,y,z values, calculatre width, height, depth
        }