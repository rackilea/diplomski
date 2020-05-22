String str = "user_id:16|login_id:6|pass_id:6|email:abc@abc.com|product_id:|name:Mike|created_date:20120101:12:22|address:US";
String[] strArr = str.split("\\|");
for (String string : strArr) {
    System.out.println("First part: " + string.substring(0, string.indexOf(":")));
    System.out.println("Second part: " + string.substring(string.indexOf(":")+1));
    System.out.println();
}