int n = Integer.parseInt(args[0]);
    double d = 0;
    for (int l = 1; l <= 4; l++){
        BenchmarkTimer timer1 = new BenchmarkTimer();
        d += timer1.value();
        System.out.println(timer1.total());
    }
    System.out.println(d);