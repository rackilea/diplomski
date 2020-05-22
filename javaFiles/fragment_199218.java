String text = "testing<hi>bye</hi><b>bla bla!";
Pattern p = Pattern.compile("<(.*?)>");
Matcher m = p.matcher(text);
int last_match = 0;
List<String> splitted=new ArrayList<>();
while (m.find()) {
        splitted.add(text.substring(last_match,m.start()));
        splitted.add(m.group());
        last_match = m.end();
    }
    splitted.add(text.substring(last_match));
System.out.println(splitted.toString());