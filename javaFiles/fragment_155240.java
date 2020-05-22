/**
 * @param href
 *            the string to check
 * @return true if href has the pdf or ps pattern.
 */
private boolean isFileForDownloading(String href) {
    final Pattern p = Pattern.compile(".+.pdf|.+.ps|.+.zip|.+.mp3");
    Matcher m = p.matcher(href);

    if (m.matches()) {
        return true;
    }

    return false;
}