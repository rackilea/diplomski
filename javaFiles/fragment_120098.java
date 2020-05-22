public static void main(String[] args) throws Exception
{
    char[] arrOperators = { ',', '^', '*', '/', '+', '-', '&', '=', '<', '>', '=', '%', '(', ')', '{', '}', ';' };
    String input = "foo^bar{hello}world"; // Expecting this to be split on the "special" chars
    String regex = "(" + new String(arrOperators).replaceAll("(.)", "\\\\$1|").replaceAll("\\|$", ")"); // escape every char with \ and turn into "OR"
    System.out.println(regex); // For interest only
    String[] parts = input.split(regex);
    System.out.println(Arrays.toString(parts));
}