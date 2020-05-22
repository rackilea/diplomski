public class Test {
    public static void main(String[] args) {
        test("Sara's dog 'bit' the neighbor.");
        test("Holy cow! screamed Jane.");
        test("Select your 'pizza' topping {pepper and tomato} follow me.");
    }
    private static void test(String s) {
        String regex = "[\\p{L}\\p{M}\\p{N}]+(?:\\p{P}[\\p{L}\\p{M}\\p{N}]+)*|[\\p{P}\\p{S}]";
        String[] parts = Pattern.compile(regex).matcher(s).results().map(MatchResult::group).toArray(String[]::new);
        System.out.println(Arrays.toString(parts));
    }
}