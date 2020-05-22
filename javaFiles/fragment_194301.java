//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
StringBuilder text = new StringBuilder();
text.append("<html><something>");
text.append("<paragraph><Sentence>text 1 qwe</Sentence></paragraph>");
text.append("<paragraph><Sentence>text 2 qwe</Sentence></paragraph>");
text.append("<zzz>this text wont go</zzz>");
text.append("<paragraph><Sentence>text 3 qwe</Sentence></paragraph>");
text.append("</something></html");
System.out.println(text.toString());

Pattern p = Pattern.compile("<paragraph>(.*?)</paragraph>");
Matcher m = p.matcher(text.toString());

while (m.find()) {
    System.out.print("Word = " + m.group() + "\n");
}