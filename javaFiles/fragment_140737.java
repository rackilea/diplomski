Third third = new Third();
    Test test = new Test(third);
    Test2 test2 = new Test2(test, third);

    Thread t1 = new Thread(test);
    Thread t2= new Thread(test2);

    t1.start();
    t2.start();
    t2.join();
    t1.join();
}