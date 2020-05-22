char[] array2 = new char[3];
array2[0] = 'a';
array2[1] = 'b';
array2[2] = 'a';
char[][] array1 = new char[6][6];
array1[0][0] = 'a';
array1[0][4] = 'q';
array1[1][1] = 'r';
array1[2][0] = 'b';
array1[3][5] = 's';
for (int i = 0; i < array2.length; ++i) {
    char ch = array2[i];
    for (int j = 0; j < array1.length; ++j) {
        for (int k = 0; k < array1[j].length; ++k) {
            if (ch == array1[j][k])
                System.out.println("array2[" + i + "] matches with array1[" + j + "][" + k + "] with char being " + ch);
        }
    }
}

Output :
array2[0] matches with array1[0][0] with char being a
array2[1] matches with array1[2][0] with char being b
array2[2] matches with array1[0][0] with char being a