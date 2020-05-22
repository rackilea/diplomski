Observable.range(1, 10)
    .map(v -> {
       if (v % 2 == 0) {
           return v - 1;
       }
       return v + 1;
    })
    .subscribe(System.out::println)