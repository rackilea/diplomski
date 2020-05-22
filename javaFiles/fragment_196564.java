boolean first = true;
query = query = "select doc from Doc doc " +
" join doc.Csts cst " +
if (firstName != null) {
    query += (first ? " where " : " and ");
    query += " cst.cstFrstNm like :FrstNm ";
    first = false;
}
query += ";";
// ...