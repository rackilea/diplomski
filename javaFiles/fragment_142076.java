public String printRow(Object[] row) {
    StringBuilder s = new StringBuilder();
    for (Object object : row) {
        System.out.println(object);
        s.append(object + "\n");
    }
    return s.toString();
}