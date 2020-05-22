String input = "Here is an example line that I might have to read example@such.com and I have to extra the username addresses pleasehelpme@such.com see?";

Pattern p = Pattern.compile("\\S+@\\S+");
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println(m.group());
}