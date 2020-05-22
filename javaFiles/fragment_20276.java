for (int x = 0, y = 0; x < this.width();) {
    if (!this.getColor(x, y).equals(typeCastedPicture.getColor(x, y))) {
        return false;
    }
    if ( y == this.height() - 1 ) {
        y = 0;
        x++;
    } else ++y;
}