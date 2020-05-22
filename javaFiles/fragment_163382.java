Map<String,Integer> map = new LinkedHashMap<String,Integer>();
int total = 0;
while (rs.next()) {
    int count =  rs.getInt(1);
    total += count;
    map.put (rs.getString(2), count);
}