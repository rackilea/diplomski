int iterationCount = 1000000; // 1 million iterations
        Long t1 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < iterationCount; i++) {
            middle = a <= b ? (c <= a ? a : c <= b ? c : b) : c <= b ? b : c <= a ? c : a;
        }
        Long t2 = Calendar.getInstance().getTimeInMillis();


        // #2 Using Collection + List + Sort
        Long t3 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < iterationCount; i++) {
            List<Integer> list = Arrays.asList(a, b, c);
            Collections.sort(list);
            middle = list.get(1);
        }
        Long t4 = Calendar.getInstance().getTimeInMillis();

        // #3Using Math's min and max
        Long t5 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < iterationCount; i++) {
            middle = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
        }
        Long t6 = Calendar.getInstance().getTimeInMillis();

        System.out.println("Time Taken #1 -> " + (t2 - t1));
        System.out.println("Time Taken #2 -> " + (t4 - t3));
        System.out.println("Time Taken #3 -> " + (t6 - t5));