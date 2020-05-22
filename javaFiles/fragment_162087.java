for (Element e : doc.select("code")) {
    if (e.attr("code").trim().equals("43683-2")) {
        Element firstHighlight = null;     
        Element sibling = e.nextElementSibling();
        while (sibling != null && firstHighlight == null) {
            if (sibling.tagName().equals("highlight")) {
                firstHighlight = sibling;
            } else {
                sibling = sibling.nextElementSibling();
            }
        }
    }
}