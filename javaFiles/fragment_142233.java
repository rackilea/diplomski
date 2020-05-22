Flowable<Integer> source = Flowable.range(1, 5);

ConnectableFlowable<Integer> cf = source.publish();

cf.filter(v -> v % 2 == 0).subscribe(v -> System.out.println("Even: " + v));

cf.filter(v -> v % 2 != 0).subscribe(v -> System.out.println("Odd: " + v));

cf.connect();