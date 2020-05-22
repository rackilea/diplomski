public static void main(String[] args) {

    Pattern p = Pattern.compile("(?:http://)?.+?(/.+?)?/\\d+/\\d{2}/\\d{2}(/.+?)?/\\w{22}");

    String[] strings ={
            "www.examplesite.com/dir1/dir2/4444/2012/06/19/title-of-some-story/FAQKZjC3veXSalP9zxFgZP/htmlpage.html",
            "www.examplesite.com/2012/06/19/title-of-some-story/FAQKZjC3veXSalP9zxFgZP/htmlpage.html",
            "www.examplesite.com/dir/2012/06/19/title-of-some-story/FAQKZjC3veXSalP9zxFgZP/htmlpage.html",
            "www.examplesite.com/dir/2012/06/19/FAQKZjC3veXSalP9zxFgZP/htmlpage.html",
            "www.examplesite.com/2012/06/19/FAQKZjC3veXSalP9zxFgZP/htmlpage.html"
    };
    for (int idx = 0; idx < strings.length; idx++) {
        Matcher m = p.matcher(strings[idx]);
        if (m.find()) {
            String dir = m.group(1);
            String title = m.group(2);
            if (title != null) {
                title = title.substring(1); // remove the leading /
            }
            System.out.println(idx+": Dir: "+dir+", Title: "+title);
        }
    }
}