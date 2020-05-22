public static void someMethod(boolean flag, Runnable block1, Runnable block2) {
    //some other code
    if(flag)
        block1.run();
    else block2.run();
    //some other code
}