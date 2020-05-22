String str = "%7B%22username%22%3A%22test1234%22%7B";
try {
    System.out.println(URLDecoder.decode(str, "utf-8"));
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}