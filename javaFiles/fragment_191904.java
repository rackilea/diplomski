final String needle = "abc(.*)def(.*)pqr(.*)xyz";
final String hayStack = "abcXdefYpqrZxyz";

// Use $ variables in String.replaceAll()
System.out.println(hayStack.replaceAll(needle, "_$1_$2_$3_"));
// Output: _X_Y_Z_


// Use Matcher groups:
final Matcher matcher = Pattern.compile(needle).matcher(hayStack);
while(matcher.find()){
    System.out.println(
        "A: " + matcher.group(1) +
        ", B: " + matcher.group(2) +
        ", C: " + matcher.group(3)
    );
}
// Output: A: X, B: Y, C: Z