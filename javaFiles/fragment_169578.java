public class Content {
private static final String HTML_A_HREF_TAG_PATTERN =
        "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
private Pattern pattern;
private Set<String> visitedUrls = new HashSet<String>();

public Content() {
    pattern = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
}

private void fetchContentFromURL(String strLink) {
    String content = null;
    URLConnection connection = null;
    try {
        connection = new URL(strLink).openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        if (scanner.hasNext()) {
            content = scanner.next();
            visitedUrls.add(strLink);
            fetchURL(content);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

private void fetchURL(String content) {
    Matcher matcher = pattern.matcher(content);
    while (matcher.find()) {
        String group = matcher.group();
        if (group.toLowerCase().contains("http") || group.toLowerCase().contains("https")) {
            group = group.substring(group.indexOf("=") + 1);
            group = group.replaceAll("'", "");
            group = group.replaceAll("\"", "");
            System.out.println("lINK " + group);
            if (!visitedUrls.contains(group) && visitedUrls.size() < 200) {
                fetchContentFromURL(group);
            }
        }
    }
    System.out.println("DONE");
}

/**
 * @param args
 */
public static void main(String[] args) {
    new Content().fetchContentFromURL("http://www.google.co.in");
}

}