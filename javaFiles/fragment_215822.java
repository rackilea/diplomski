public class MyWebResponse extends ServletWebResponse {
    static Pattern bodyContentPattern = Pattern.compile("<body[^>]*>((?s).*)</body>");
    static Pattern headContentPattern = Pattern.compile("<head[^>]*>((?s).*)</head>");

    public MyWebResponse(ServletWebRequest webRequest,
            HttpServletResponse httpServletResponse) {
        super(webRequest, httpServletResponse);
    }

    @Override
    public void write(CharSequence sequence) {
        String string = sequence.toString();
        // if there is a html tag, take the body content, append the header content in
        // a div tag and write it to the output stream
        if (string.contains("</html>")) {
            StringBuilder sb = new StringBuilder();
            sb.append(findContent(string, bodyContentPattern));

            String headContent = findContent(string, headContentPattern);
            if (headContent != null && headContent.length() > 0) {
                sb.append("<div class=\"head\">");
                sb.append(headContent);
                sb.append("</div>");
            }
            super.write(sb.toString());
        } else {
            super.write(sequence);
        }
    }

    private String findContent(String sequence, Pattern p) {
        Matcher m = p.matcher(sequence);
        if (m.find()) {
            return m.group(1);
        }
        return sequence;
    }
}