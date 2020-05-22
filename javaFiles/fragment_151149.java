int xSize = 21;
int ySize = 21;
String sign = "X";

for (int i = 0; i < xSize; ++i) {
    for (int j = 0; j < ySize; ++j) {
        if (i == j) {
            System.out.print(sign);
        } else if (i == ySize - j - 1) {
            System.out.print(sign);
        } else {
            System.out.print(" ");
        }

    }
    System.out.println();
}