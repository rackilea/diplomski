String updateFilter = "UPDATE payload_roas SET filtered = TRUE WHERE asn = ? AND prefix= ? AND max_length = ?";
PreparedStatement ps=  connection.prepareStatement(updateFilter);
HashSet<String> hashKeys = new HashSet<>();
for(int i = 0; i < roas.size(); i++) {
    roa = roas.get(i);
    String key = roa.getAsn() + roa.getPrefix().toString() + roa.getMax_length() + roa.isWhitelist + roa.isFilter;
    if (!hashKeys.contains(key)) {
        hashKeys.add(key);
        ps.setLong(1, roa.getAsn());
        ps.setObject(2, roa.getPrefix(), OTHER);
        ps.setInt(3, roa.getMax_length());
        ps.setBoolean(4, roa.isWhitelist);
        ps.setBoolean(5, roa.isFilter);
        ps.addBatch();
    }
}