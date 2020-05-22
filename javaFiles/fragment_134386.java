StringBuilder sql = new StringBuilder("SELECT num FROM parcels WHERE code_initial_right =");
if (docd != null) {
   sql.append("(SELECT code_document FROM documents WHERE number_document=? or date_document='"+docd+"')");
}else {
   sql.append("(SELECT code_document FROM documents WHERE number_document=?)");
}
ps = conn.prepareStatement(sql.toString());