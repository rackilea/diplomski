int i = 28;
int tenEurosCount = i / 10;
i = i - 10 * tenEurosCount;
int fiveEurosCount = i / 5;
i = i - 5 * fiveEurosCount;
int twoEurosCount = i / 2;
i = i - 2 * twoEurosCount;
System.out.println(tenEurosCount + "x 10 \n" + fiveEurosCount + "x 5 \n" + twoEurosCount + "x 2 \n" + i + "x 1 \n");