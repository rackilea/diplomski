public static void main(String[] args) {
    String s = "5 13-DEC-2010 16:47 A Tach 220 380";
    String re = "(\\d+)\\s+(\\d{1,2}-[A-Z]{3}-\\d{4})\\s+(\\d{2}:\\d{2})\\s+([\\w\\s+]*)\\s+(\\d+)\\s+(\\d+)";
    Pattern p = Pattern.compile(re);
    String number=null,date=null,time=null,type=null,num1=null,num2=null;
    Matcher m = p.matcher(s);
    if (m.matches()) {
        number = m.group(1);
        date = m.group(2);
        time = m.group(3);
        type = m.group(4);
        num1 = m.group(5);
        num2 = m.group(6);
    }
    System.out.println(number);
    System.out.println(date);
    System.out.println(time);
    System.out.println(type);
    System.out.println(num1);
    System.out.println(num2);
}