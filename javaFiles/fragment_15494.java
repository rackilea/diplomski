/*
  * Return the difference between an element an the element below it
  */

public void down(int x, int y) {

    if (y == array.length - 1) { 
       \\ on the bottom edge
       return 0;
    }   

    return array[y][x] - array[y + 1][x];

}