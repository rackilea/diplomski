public static void main(String[] args) {
    int i = 0;
    while (in.hasNext()) {
        String s = in.nextLine();
        names.put(i, Arrays.asList(s.split(" ")));
        i++;
    }
}