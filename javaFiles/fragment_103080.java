public static void methodOne() {
    methodToCall1();
}

public static void methodTwo() {
    methodToCall2();
}

public static void methodThree() {
    methodToCall3();
}

public static void methodToCall1() {
    int x = 0;
    x = x - 3; //some custom logic to prep argument
    commonLogic(x);
}

public static void methodToCall2() {
    //Method 2 logic
    int x = 0;
    x = x + 3; //some custom logic to prep argument
    commonLogic(x);
}

public static void methodToCall3() {
    //Method 3 logic
    int x = 0;
    x = x * 3; //some custom logic to prep argument
    commonLogic(x);
}

public static void commonLogic(int arg1){
     //peform common logic
}