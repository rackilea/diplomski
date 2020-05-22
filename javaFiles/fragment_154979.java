public static void main(String args[]) {
    String statement = "reverse this statement";
    String reversed = reverse(statement);

    if (!reversed.equals("tnemetats siht esrever")) {
        throw new RuntimeException("the string was not correctly reversed");
    }

    // reversing twice should yield the original string
    if (!statement.equals(reverse(reverse(statement)))) {
        throw new RuntimeException("reversing a string twice should yield the original, but it doesn't");
    }
}