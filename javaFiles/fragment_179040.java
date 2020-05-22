int o = 0;
    int numRem = 0;
    int numLim = 0;
    while((sc.hasNextInt())&&(o<1)) {
  ----> int numT = sc.nextInt();  // You are re-declaring numT
        numLim = sc.nextInt();
        numRem = sc.nextInt();
        o++;
    }