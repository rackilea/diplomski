double someNum = 5.6d;
DecimalFormat df = new DecimalFormat("#.#");
String num = df.format(someNum);
if (num.substring(num.length - 1).equals("0")) {
    num = num.substring(0, num.length - 2);
}
System.out.println(num);