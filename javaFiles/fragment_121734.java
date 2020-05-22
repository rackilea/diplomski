String data = "(output !==(not output)) | (output)";
Matcher m = Pattern.compile("(\\w+)\\s*(?=!?==)(.*)\\1").matcher(data);
//                           ^-group1          ^   ^-repeated group1
//                                             |group 2
while (m.find()) {
    System.out.println(m.group(2));//match from group 2
}