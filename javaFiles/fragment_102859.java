public static int[] countGettersandSetters (String className)
    int[] count = new int[2];
    Method[] methods = Class.forName(className).getDeclaredMethods();
    for (Method method : methods) {
        if (method.getName().startsWith("set")) {
            count[0]++;
        } else if (method.getName().startsWith("get") ||
                   method.getName().startsWith("is")) { // to incl. boolean properties
            count[1]++;
        } 
    }
    return count;
}