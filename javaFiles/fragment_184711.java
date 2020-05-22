final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    final List<Future<String>> results = new LinkedList<Future<String>>();
    // now you have all coords in memory
    for (int i = 0; i < coords.size(); i++) {
        final int index = i;
        final Coord c1 = coords.get(index);
        results.add(executor.submit(new Callable<String>() {
            public String call() {
                final StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < coords.size(); j++) {
                    final Coord c2 = coords.get(j);
                    final double foo = ((c1.a - c2.a) * (c1.a - c2.a)) * 1;
                    final double goo = ((c1.b - c2.b) * (c1.b - c2.b)) * 1;
                    final double hoo = ((c1.c - c2.c) * (c1.c - c2.c)) * 2;
                    final double joo = ((c1.d - c2.d) * (c1.d - c2.d)) * 2;
                    final double koo = ((c1.e - c2.e) * (c1.e - c2.e)) * 4;
                    final double loo = ((c1.f - c2.f) * (c1.f - c2.f)) * 4;
                    final double zoo = Math.sqrt(foo + goo + hoo + joo + koo + loo);

                    final DecimalFormat df = new DecimalFormat("#.###");
                    stringBuilder.append(index + " " + j + " " + df.format(zoo));
                    System.out.println(index);
                }
                return stringBuilder.toString();
            }
        }));
    }
    for (Future<String> result : results) {
        pout.print(result.get());
    }
    pout.flush();
    pout.close();
    executor.shutdown();