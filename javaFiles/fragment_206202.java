public static void main(String[] args) throws Exception {
        MainController mc= new MainController();
        mc.setProblem();
        MainController mc2 = new MainContoller();
        mc1.setProblem();
        Thread1 thread1 = new Thread1("thread1",mc.problem,approach1);
        Thread2 thread2 = new Thread2("thread2",mc1.problem,approach2);
        thread1.start();
        thread2.start();
    }