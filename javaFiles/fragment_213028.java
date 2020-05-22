String str = "";
int row = 0, col = 0;
int i = 0, totalLen = 57;

while (i < totalLen) {
    if (col < key[row].length) {
        str += col++ + " ";
        i++;
    } else {
        System.out.println(str);
        str = "";
        row++;
        col = 0;
    }
}
System.out.println(str); // prints the last line