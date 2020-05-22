// Flag used to know if it has already been found
boolean found = false;
for (Iterator<String[]> it = data.iterator(); it.hasNext();) {
    String[] values = it.next();
    // Check if the first element of the array is "abc"
    if (values.length > 1 && "abc".equals(values[0])) {
        if (found) {
            // Already found so we remove it
            it.remove();
            continue;
        }
        // Not found yet so we simply print it
        System.out.println(values[1]);
        found = true;
    }
}