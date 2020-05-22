int xLenght = arr.length;
int yLength = arr[0].length;
BufferedImage b = new BufferedImage(xLenght, yLength, 3);

for(int x = 0; x < xLenght; x++) {
    for(int y = 0; y < yLength; y++) {
        int rgb = (int)arr[x][y]<<16 | (int)arr[x][y] << 8 | (int)arr[x][y]
        b.setRGB(x, y, rgb);
    }
}
ImageIO.write(b, "Doublearray", new File("Doublearray.jpg"));
System.out.println("end");