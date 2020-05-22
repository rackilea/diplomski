for(Iterator<Map<String, Object>> iter = list.iterator(); iter.hasNext(); ) {
    Map<String, Object> map = iter.next();
    Object c_id = map.get("c_id");
    if (c_id == null || c_id.equals(matching_c_id))
        iter.remove();
}