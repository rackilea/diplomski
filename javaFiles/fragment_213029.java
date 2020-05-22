String str = "";
int totalLen = 57;

for (int i = 0, row = 0, col = 0; i < totalLen; i++) {
    str += col++ + " ";
    if (col == key[row].length) {
        row++;
        col = 0;
        System.out.println(str);
        str = "";
    }
}