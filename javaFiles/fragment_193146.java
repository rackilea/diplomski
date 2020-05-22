private static int soeCount = 0;

//...

} catch (StackOverflowError soe) {
    soeCount++;
    System.out.println(atomicInt + ":" + staticInt + " -> " + soeCount);
    // staticInt gets more count, why so?
}