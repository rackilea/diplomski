public String getMenu(Page page, boolean isRoot) {
    StringBuilder output = new StringBuilder();
    if (isRoot) {
        output.append("<ul id=\"drop-menu\"");
        output.append(" class=\"popup-menu\">");
        }
    else {
        output.append("<ul>");
        }
    output.append("<li><a href=\"")
        .append(page.getPath())
        .append(".html\" class=\"showSubPage\" rel=\"")
        .append(rootPage.getPath()).append("\">");
    String title = page.getPageTitle() == null ? page.getTitle() : page.getPageTitle();
    output.append(title);
    output.append("</a>");

    Iterator<Page> subPages = page.listChildren();
    while(subPages.hasNext()){
        output.append(getMenu(subPages.next(), false));
    }
    output.append("</li>");
    output.append("</ul>");
    return output.toString();
}