hexInfo[i][j] = new HexInfo(i,j);
hexInfo[i][j].setIsVisible(true);
hexInfo[i][j].setIsOccupied(true);

Color.rgba8888ToColor(hexInfo[i][j].getColour(), savedScreenData.getPixel(i, j));

//It is now *really* definitely set because this gives the correct colours
System.out.println(hexInfo[i][j].getColour());