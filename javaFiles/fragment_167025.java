public static void main(String[] args) {

        String aNbN = "(?x) (?:  a  (?= a* (\\1?+ b))  )+ \\1";
        String[] tests = {
                "",      // false
                "ab",    // true
                "abb",   // false
                "aab",   // false
                "aabb",  // true
                "abab",  // false
                "abc",   // false
                repeat('a', 5000) + repeat('b', 4999), // false
                repeat('a', 5000) + repeat('b', 5000), // true
                repeat('a', 5000) + repeat('b', 5001), // false
        };
        for (String test : tests) {
                System.out.printf("[%s]%n  %s%n%n", test, test.matches(aNbN));
        }

}

static String repeat(char ch, int n) {
        return new String(new char[n]).replace('\0', ch);
}