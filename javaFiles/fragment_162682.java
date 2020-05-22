int[] secondColVal = new int[termVectors.length];
int[] thirdColVal = new int[termVectors.length];

for (int i = 0; i < termVectors.length; ++i) {
    System.out.print("(");
    for (int k = 0; k < 3; ++k) {
    if (k > 0) System.out.print(", ");
    System.out.printf("% 5.2f",termVectors[i][k]);
    if(k==1)
    secondColVal[i] = termVectors[i][k];
    if(k==2)
    thirdColVal[i] = termVectors[i][k];
    }
    System.out.print(")  ");
}