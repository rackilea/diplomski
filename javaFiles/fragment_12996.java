StringBuilder sb = new StringBuilder("SELECT * from animals WHERE animal_name IN (");
// 1. assemble query parameters
for (int i = 0; i < arrayVals.size(); i++) {
    sb.append("?");
    if (i + 1 < arrayVals.size()) sb.append(",");
}
sb.append(")");
// 2. add the variables
PreparedStatement st = conn.prepareStatement(sb.toString());
for (int i = 0; i < arrayVals.size(); i++) {
    // May need to replace setter depending on type of object
    st.setObject(i + 1, o);
}