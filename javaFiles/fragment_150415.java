Pattern fpNumber = Pattern.compile("[+-]?\\d*\\.?\\d*");
String[] positive = {"+", "-", "123", ".24", "-1.04" };
String[] negative = { "+A", "-B", "123z", ".24.", "-1.04+" };
for(String p: positive) {
    System.out.println("should accept more input: "+p
                      +", couldMatch: "+couldMatch(p, fpNumber));
}
for(String n: negative) {
    System.out.println("can never match at all: "+n
                      +", couldMatch: "+couldMatch(n, fpNumber));
}