String example = "your mobile number is <A> and username is <B> thanks <C>";
//                            ┌ positive look-behind for left delimiter
//                            |    ┌ 1+ of any character, reluctantly quantified
//                            |    |   ┌ positive look-ahead for right delimiter
//                            |    |   |
Matcher m = Pattern.compile("(?<=<).+?(?=>)").matcher(example);
while (m.find()) {
    // no index for back-reference here, catching main group
    System.out.println(m.group());
}