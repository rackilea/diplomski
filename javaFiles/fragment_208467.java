private String getText(Part p) throws MessagingException, IOException {
    System.out.println("getText contentType "+p.getContentType());
    if (p.isMimeType("text/plain")) {
        String s = (String) p.getContent();
        System.out.println(s);
        return s;
    } else if (p.isMimeType("text/html")) {
        // the last two parameters of this may need to be modified
        String s = Jsoup.parse(p.getInputStream(), null, null).text();
        System.out.println(s);
        return s;
    } else if (p.isMimeType("multipart/alternative")) {
        Multipart mp = (Multipart) p.getContent();
        String text = "";
        for (int i = 0; i < mp.getCount(); i++) {
            Part bp = mp.getBodyPart(i);
            if (bp.isMimeType("text/*")) {
                String s = getText(bp);
                if (s != null) {
                    text += s;
                }
            }
        }
        return text;
    }
    return null;
}