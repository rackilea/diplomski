String example = "your mobile number is <A> and username is <B> thanks <C>";
//                           ┌ left delimiter - no need to escape here
//                           | ┌ group 1: 1+ of any character, reluctantly quantified
//                           | |   ┌ right delimiter
//                           | |   |
Matcher m = Pattern.compile("<(.+?)>").matcher(example);
while (m.find()) {
    System.out.println(m.group(1));
}