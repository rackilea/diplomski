while(pxMatcher.find()) {
    System.out.println(pxMatcher.group());
    String urlString =pxMatcher.group();
    if(!urlString.matches("http://|https://")) {
        System.out.println("Firts: "+temp.trim());
        System.out.println(urlString);
        temp = temp.replace(urlString, "");
        System.out.println("Remove: "+temp);
     }
}