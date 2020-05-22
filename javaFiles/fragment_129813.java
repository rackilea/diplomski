int index = 0;
for (Iterator<String[]> it = data.iterator(); it.hasNext();index++) {
    ...
    if (values.length > 1 && "abc".equals(values[0])) {
        System.out.printf("abc found at %d%n", index);
        ...
    }
}