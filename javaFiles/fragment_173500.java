Pattern p = Pattern.compile("(?=[^@])(.+?)#(\\d)#(\\d)(?=@)");
Matcher m = p.matcher("Matematika 1#1#0@Fizika 1#1#6@Osnovi na injenernoto proektirane 1#1#5@PIK 1#1#6@Matematika 2#2#6@Fizika 2#2#6@Osnovi na injenernoto proektirane 2#2#4@");
while(m.find())
{
    if (m.groupCount() == 3) {
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        System.out.println(m.group(3));
   }
}