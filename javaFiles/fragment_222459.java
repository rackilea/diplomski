Random rnd = new Random();
    for (int i=0; i<1000; i++) {
        int time = rnd.nextInt(121);
        Integer calls = values.get(time);
        if (calls == null) {
            calls = Integer.valueOf(0);
        }
        calls += 1;
        values.put(time, calls);
    }