ArrayList<PluginProperty> pr = pxs.getResults(contextId);
    for (int i = 0; i < pr.size(); i++) {
        String id = "{" + i + "}";
        String propName = pr.get(i).getName();
        String propType = pr.get(i).getType();
        String prop = "";
    .
    .
    .
else if (propType.equalsIgnoreCase("StringList")) {
    int size = doc.getProperties().get(propName).getStringListValue().size();
    for (int j = 0; j < size; j++) {
        prop += doc.getProperties().get(propName).getStringListValue().get(j).toString() + "; ";
    }
}
else if (propType.equalsIgnoreCase("StringValue")) {
    prop = doc.getProperties().get(propName).getStringValue();
}
    .
    .
    .
    row.addAttribute(id, prop, JSONResultSetRow.TYPE_STRING, null, prop);
}