public void visitTag(Tag tag) {
    if ("img".equals(tag.getTagName())) {
        if ("DataIcon".equals(tag.getAttribute("src"))) {
            tag.setAttribute("src", icon);
        }
    }        
}