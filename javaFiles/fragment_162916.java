// original text
String text = "bitcoin litecoin 11\nexit\nbitcoin litecoin 16\n\"\"ripple 77\n\"\"exit\nexit\napple banana 55\nexit"
    + "\napple banana 55/2\n\"\"coconut 1\n\"\"exit\n\"\"dragonfruit 2\n\"\"exit\nexit\nnorth west 11\nexit"
    + "\nsouth west 7\n\"\"north 12\n\"\"exit\nexit";
//                           | starting with fruit
//                           |            | anything in the middle
//                           |            |  | ends with newline + exit, then
//                           |            |  |     | newline or end of input
//                           |            |  |     |        | dot also represents 
//                           |            |  |     |        | newlines
Pattern p = Pattern.compile("apple banana.*?\nexit(\n|$)", Pattern.DOTALL);
StringBuffer replacement = new StringBuffer();
Matcher m = p.matcher(text);
// iteratively replacing with empty
while (m.find()) {
    m.appendReplacement(replacement, "");
}
// appending tail text after last find
m.appendTail(replacement);
System.out.println(replacement);