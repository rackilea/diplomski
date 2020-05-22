Scanner sc = new Scanner(System.in);
try {    
  ...
  int select;
  for (;;) {
    try {
      select = sc.nextInt();
      break;
    } catch (InputMismatchException ignored) {
      continue;
    }
  }
  // select is always initialized in that case
  switch (select) {
    ...
  }
}