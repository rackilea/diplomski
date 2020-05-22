public static void main(String[] args) throws Exception {

    String regex = "<td><input type=\"radio\" name=\"userInput\" value=\"(\\d)+.(\\d)+\">(\\d)+( ?\\/? ?)(\\d)+<\\/td>";
    String test = "<td><input type=\"radio\" name=\"userInput\" value=\"1.1\">112/2</td>";
    System.out.println("Does: " + test);
    System.out.println("Match: the regex pattern: " + regex);
    System.out.println("Answer: " + test.matches(regex));

}