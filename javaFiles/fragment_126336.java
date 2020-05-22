while (s.hasNext()) {
    String temp = s.nextLine();
    for (int i = temp.length() - 1; i >= 0; i--) {
        out.print(temp.charAt(i));
    }
    out.println();
}