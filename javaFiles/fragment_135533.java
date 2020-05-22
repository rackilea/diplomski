String data = "*..***...**...****....*....*****..**";

Pattern p = Pattern.compile("\\*\\*|\\*");
Matcher m = p.matcher(data);

int tmp1 = 0, tmp2 = 0;
while (m.find()) {
    if (m.group().length() == 1)//found *
        tmp1++;
    else                        //found **
        tmp2++;
}
System.out.println(tmp1);
System.out.println(tmp2);