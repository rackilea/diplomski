Flowable.fromIterable(letters)
         .parallel(letters.size())
         .runOn(Schedulers.from(fixedThreadPool))
         .sequential()
         .forEach(data -> System.out.println(data + " forEach, thread is " + 
                          Thread.currentThread().getName()));