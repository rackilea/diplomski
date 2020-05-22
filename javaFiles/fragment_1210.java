...
private Content getValue(FieldDoc member) {
    Content valueContent;
    if ("char".equals(member.type().toString())) {
        valueContent = new StringContent("'" 
            + (char) ((Integer) member.constantValue()).intValue()
            + "'"
        );
    } else {
        valueContent = new StringContent(member.constantValueExpression());
    }
    Content code = HtmlTree.CODE(valueContent);
    return HtmlTree.TD(HtmlStyle.colLast, code);
}
...