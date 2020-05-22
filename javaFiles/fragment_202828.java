public void printRectangle() {
    int count = 0;
    String indents = "";
    String topBottom = "";
    String middle = "";
    String line = "";
    // Creates the indent string
    while (count < indent) {
        indents += " ";
        count++;
    }
    // Top boarder and bottom one
    count = 0;
    while (count < this.width) {
        topBottom += this.pen;
        count++;
    }
    // Fill inside square
    this.width = this.width - 2;
    count = 0;
    while (count < this.width) {
        middle += this.fill;
        count++;
    }
    // Prints square
    line = indents + this.pen + middle + this.pen;
    topBottom = indents + topBottom;
    count = 0;
    while (count < this.length) {
        if (count == 0 || count == this.length - 1) {
            System.out.println(topBottom);
            count++;
        } else {
            System.out.println(line);
            count++;
        }
    }
}