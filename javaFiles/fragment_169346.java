public static void main(String[] args) {
    test();
}

public static void test() {
    // Print it three times under each other, 5 times next to each other 
    // With a size of 9 plus
    printHourglass(3,5,9);
}

private static void printHourglass(int column, int times, int size) {
    for(int i = 0;i<column;++i) {
        // If it is the first iteration print the first line, otherwhise
        // Leave out the first only plus line
        printHourglassRow(times, size, i == 0 ? 0 : 1);
    }
}

private static void printHourglassRow(int times, int size, int start) {
     // If it is not the first hourglass don´t print the first only plus row
    int printableStars = start == 0 ? size : size-2;
    int printableSpaces = start == 0 ? 0 : 1;
    // If the size is even we need to print one row less
    size = size % 2 == 0 ? size-1:size;
    for(int i = start;i<size;++i) {
        // Decides if we should print whitespaces or spaces first.
        // only The first and last row start with the plus 
        int mode = (i == size || i == 0) ? 1 : 0;
        //System.out.println(mode);
        //System.out.println(printableStars);
        // We are printing each column, we start with column 0
        int column = 0;
        // We print until we did reach the last column.
        while(column<times*size) {
            // If we are in print plus mode the next thing we print
            // will be a space, so switch mode and print stars as long as we should
            if(mode == 1) {
                mode = 0;
                for(int j = 0;j<printableStars;++j) {
                    printPlus();
                    ++column;
                }
            // If we are in print whitespace mode the next thing we print
            // will be a space, so switch mode and print whitespaces as long as we should
            } else {
                mode = 1;
                // If we reached the second hourglass (column > size/2)
                // Then we need to print twice as much whitespaces
                int sizeHalf = size % 2 == 0? size/2 : size/2+1; 
                for(int j = 0;column > sizeHalf ? j<printableSpaces*2:j<printableSpaces;++j) {
                    printSpace();
                    ++column;
                }
            }
        }
        // We are not in the middle of the hourglass so
        // We print two stars less and one whitespace more.
        if(size - 2*i > 2) {
            ++printableSpaces;
            printableStars -= 2;
        // If we are reaching the point where we are in the middle
        // Of the houreglass we need to print one whitespace less 
        // and two plus more.
        } else {
            --printableSpaces;
            printableStars += 2;
        }
        // Linebreak
        System.out.println();
    }
}

private static void printPlus() {
    System.out.print("+");
}

private static void printSpace() {
    System.out.print(" ");
}