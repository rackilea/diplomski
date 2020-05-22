Pattern p = Pattern.compile("\"[^\"]+\"|\\S+");
//pattern will find strings between quotes or separate words
Matcher m = p.matcher(userCmd);
while (m.find()) {
    System.out.println("adding " + m.group());//just for debugging 
    list.add(m.group());
}