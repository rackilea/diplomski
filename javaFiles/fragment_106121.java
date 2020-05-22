Random random = new Random();
int numberOfMethods = 4;

switch(random.nextInt(numberOfMethods)) {
     case 0: 
          method1();
          break;
     case 1: 
          method2();
          break;
     case 2: 
          method3();
          break;
     case 3: 
          method4();
          break;
     default: 
     method1();
}