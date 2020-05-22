public static void main(String[] args) {
    String str = "I am a girl";
    StringBuilder sb = new StringBuilder();
    // split() returns an array of Strings, for each string, append it to a StringBuilder by adding a space.
    Arrays.asList(str.split("\\s+")).stream().forEach(s -> {
        sb.append(new StringBuilder(s).reverse() + " ");
    });
    String reversed = sb.toString().trim(); // remove trailing space
    System.out.println(reversed);
}