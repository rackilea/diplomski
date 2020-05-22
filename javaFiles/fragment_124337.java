/**
* Find the structure specified in p1, p2, p3, p4 and p5 rotated by 90
* degrees rot times
*
* @param x   X-Position of the structure
* @param y   Y-Position of the structure
* @param rot How many times to rotate by 90 degrees
* @param p1  A piece of the structure
* @param p2  A piece of the structure
* @param p3  A piece of the structure
* @param p4  A piece of the structure
* @param p5  A piece of the structure
* @return The ArrayList containing all found stones
*/
private ArrayList<int[]> findStructure( int x, int y, int rot, int[] p1, int[] p2, int[] p3, int[] p4, int[] p5 ) {
    ArrayList<int[]> stones = new ArrayList<>();

    /* Rotate shape by 90 degrees rot times */
    for( int i = 1; i <= rot; i++ ) {
        /* Rotate 90 degress */
        p1 = new int[]{-p1[1], p1[0]};
        p2 = new int[]{-p2[1], p2[0]};
        p3 = new int[]{-p3[1], p3[0]};
        p4 = new int[]{-p4[1], p4[0]};
        p5 = new int[]{-p5[1], p5[0]};
    }

    // Do stuff and see if your pattern matches the actual grid content
    // ...

    return stones;
}