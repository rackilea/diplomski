String[] urls = new String[]{
    "xxxxxxxxxxxxx?id=123", "xxxxxxxxxxxxx?id=123&xxxxxxxx", 
    "xxxxxxxxxxxxx?xxxxxx&id=123", "xxxxxxxxxxxxx?xxxxxx&id=123&xxxxx"
};
for (String url : urls) {
    System.out.println(
            url.replaceAll("([\\?&]id=\\d+$)|(id=\\d+&)", "")
    );
}