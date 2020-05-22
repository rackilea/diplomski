String strings = (num.split("[^+|*|/|-]"));
for (String string : strings) {
    if (!string.equals("")) {
        System.out.println(string);
    }
}