for(int r = 0; r < drawing.array.length; r++) {
    for(int c = 0; c < drawing.array[r].length; c++) {
        outFile.print(drawing.array[r][c]);
        outFile.print(" ");
    }
}