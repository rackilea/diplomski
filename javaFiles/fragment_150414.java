List<Integer> numbers = new ArrayList<>();
for (String s : str) {
    try {
         numbers.add(Integer.valueOf(s));
    } catch (NumberFormatException e) {
         System.out.println(s + " not a number");
    }
}