public static long getMethodTimes(Class c) {
        long startTime = currentTimeMillis();
        getClassToWrap(c);
        System.out.println("Time passed = " + (currentTimeMillis() - startTime));
        System.out.println(startTime);
        return startTime;
    }