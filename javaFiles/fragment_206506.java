1) you need to initialize countDouble
   countDouble = 0;
   you're trying to do this countDouble++ before it's been ititialized

2) double = next2 = input.nextDouble();
   I believe should be this
   double next2 = input.nextDouble();

3) there no such variable countIntC
   you're trying to countIntC++
   should be countInt++