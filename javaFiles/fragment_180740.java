double width = 122.52914 - 122.22839;
double height = 11.20804 - 11.06926;
int numbSquares = 10;
int lengthOfOneSquare = width/numbSquares;

HashMap<Double[], String> hmap = new HashMap<Double[], String>();

for (double x = 11.20804; x <= 11.06926 - lengthOfOneSquare; x += lengthOfOneSquare) {
    for (double y = 122.22839; y <= 122.52914 - lengthOfOneSquare; y+= lengthOfOneSquare) {
        Double[] location = new Double[]{x, y};
        String id = x+""+y;    <--- converts x and y to a string
        hmap.put(location, id);
    }
}