int[][] massiveArray = new int[1000][1000];

final int valueTofind = 27;
// assign the value to find at position (400, 100)
massiveArray[400][100] = valueTofind;

int i_value = -1;
int j_value = -1;

// find the first occurrance of valueTofind by looping through the array
outer: for (int i = 0; i < massiveArray.length; i++) {
    for (int j = 0; j < massiveArray[0].length; j++) {
        if (massiveArray[i][j] == valueTofind) {
            i_value = i;
            j_value = j;
            break outer;
        }
    }
}

System.out.println(String.format("First position for %d is at (%d, %d)",
     valueTofind, i_value, j_value));