public static void printIt(A a) {
    if(a instanceof B) {
    ((B)a).printB();
    } else if(a instanceof C) {
       ((C)a).printC();
    } else {
      a.printA(); 
    }

}