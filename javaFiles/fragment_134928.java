String testScript = "while(true) { } while   (10 < 7) { } while((10 < 7)) { }";
Pattern p = Pattern.compile("while\\s*\\(");
Matcher m = p.matcher(testScript);

int counter = 0;
StringBuffer sb = new StringBuffer();

while(m.find()){
    m.appendReplacement(sb, "while(arg"+ (counter++) + " < 5000 && ");
}
m.appendTail(sb);

String result = sb.toString();
System.out.println(result);