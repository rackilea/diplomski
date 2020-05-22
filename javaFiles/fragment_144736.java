final int charWidth = 64;
final int charHeight = 64;
final int charCols = 11;
final int charRows = 1;
for (int i = 0; i < charCols; i++) {
    for (int j = 0; j < charRows; j++) {
        charSheet[i * charRows + j] = charSheetBig
          .getSubimage(i * charWidth, j * charHeight, charWidth, charHeight);
    }
 }