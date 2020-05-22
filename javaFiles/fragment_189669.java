String str = "60730027    6297282530  fat Albert Einstein goin in right now over here!!!  2009-12-03 01:35:22 ";
Pattern p = Pattern.compile("[a-zA-Z']+");
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.print(m.group()+" ");
}