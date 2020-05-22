public static char[][] parseShape(String layout, char displayChar) throws Exception {
    int height = 0;
    Scanner data = new Scanner(layout);
    ArrayList<String> lines = new ArrayList<String>();

    // parse layout into an array of lines to determine dimensions
    while (data.hasNextLine()) {
        String line = data.nextLine();
        lines.add(line);
        height = line.length();
    }
    int width = lines.size();
    char[][] temp = new char[height][width];
    Boolean row0 = false;
    Boolean col0 = false;
    Boolean rowLast = false;
    Boolean colLast = false;

    // parse array of lines in char array and check for constraints
    for (int w = 0; w < width; w++) {
        String line = lines.get(w);
        for (int h = 0; h < height; h++) {
            char c = line.charAt(h);
            if (c == displayChar) {

                // we are looking at the display characters,
                // check if we're in any of rows of columns that matter
                if (h == 0)
                    row0 = true;
                if (w == 0)
                    col0 = true;
                if (h == height - 1)
                    rowLast = true;
                if (w == width - 1)
                    colLast = true;
            }
            temp[h][w] = c;
        }
    }

    // if any of the constraints are not true, the layout is invalid
    if(!row0) {
        throw new Exception("no block in Oth row");
    }
    if(!col0) {
        throw new Exception("no block in Oth column");
    }
    if(!rowLast) {
        throw new Exception("no block in last row");
    }
    if(!colLast) {
        throw new Exception("no block in last column");
    }
    return temp;
}