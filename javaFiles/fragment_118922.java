for (int i = 1; i <= 9; i += 2) {
   for (int j = 0; j < (9 - i) / 2; j++) System.out.print('-');
   for (int k = 0; k < i; k++) System.out.print(i);
   for (int l = 0; l < (9 - i) / 2; l++) System.out.print('-');
   System.out.println();
}