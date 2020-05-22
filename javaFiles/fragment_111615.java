BufferedImage b = new BufferedImage(arr.length, arr[0].length, 3); 
Graphics c = b.getGraphics();

for(int i = 0; i<arr.length; i++) {
    for(int j = 0; j<arr[0].length; j++) {
        c.drawString(String.valueOf(arr[i][j]), 0+(i*10), 0+(i*10));
    }
}
ImageIO.write(b, "Doublearray", new File("Doublearray.jpg"));
System.out.println("end");