public static Object[][] provideData(Object... arObj) {
    Object[][] arObject = new Object[arObj.length][];

    int index = 0;
    for (Object obj : arObj) {
        arObject[index++] = new Object[]{obj};
    }
    return arObject;
}