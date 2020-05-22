builder.append("TABLE.METACODES in (");
EntityMetaCodes emc = cto.getEntityMetaCodes();
builder.append("'" + emc.remove(0) + "'"); // assuming it's an ArrayList, remove(0) takes out the
                               // first element and moves everything else to the left
for(String metaCode : emc) {
    builder.append(", '" + metaCode + "'");
}
builder.append(")");