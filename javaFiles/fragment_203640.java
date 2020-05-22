private String getPartialIssueList() {
    String listFromProperties = getPropertyValue("propagateList");
    StringTokenizer token = new StringTokenizer(listFromProperties, ",");
    StringBuilder partialListString = new StringBuilder();
    partialListString.append(" AND ");
    partialListString.append("(");

    // Prepare key condition
    StringBuilder orKeys = new StringBuilder();
    while(token.hasMoreElements()) {
        // Replace token.nextToken() to token.nextToken().replaceAll("\"", "") if you don't want quotes
        orKeys.append("key=" + token.nextToken() + " OR ");
    }
    // Remove last "OR" and concatenate 
    partialListString.append(orKeys.toString().replaceAll(" OR $", ""));
    partialListString.append(")");

    return partialListString.toString();
}