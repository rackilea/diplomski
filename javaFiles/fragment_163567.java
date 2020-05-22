String lines[] = input.split(";");
int width = lines.length;
String cells[] = lines[0].split(",");
int height = cells.length;
int output[][] = new int[width][height];

for (int i=0; i<width; i++) {
    String cells[] = lines[i].split(",");
    for(int j=0; j<height; j++) {
        cells[i][j] = Integer.parseInt(cells[j]);
    }
}