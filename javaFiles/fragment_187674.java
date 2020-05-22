// I use java.util.ArrayList because using its add(..) method is convenient here.
// The proper forumula for anticipated number of nodes is: base×(base+1)÷2
final List<Field> fields = new ArrayList<Field>(BASE*(BASE+1)/2);
// I use a java.awt.Point to store the (x,y) value of the first node of the row.
// This clarifies the meaning, rather than using ints or long inline expressions.
final Point rowStart = new Point(PANEL_WIDTH/2, DIAMETER);

// The number of rows equals the number of nodes on the final row.
for (int row = 1; row <= BASE; row++) {
    // The nth row has n nodes.
    for (int circle = 0; circle < row; circle++) {
        // Each row starts at rowStart and each subsequent circle is offset to 
        // the right by two times the circle diameter.
        fields.add(new Field(0, rowStart.x + circle*DIAMETER*2, rowStart.y));
    }
    // Each subsequent row starts a little down and to the left of the previous.
    rowStart.x -= DIAMETER;
    rowStart.y += DIAMETER;
}