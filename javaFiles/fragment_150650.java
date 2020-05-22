String user = user field from line
String value = value field from line

Collection<String> values = map.get(user);
if (values==null) {
    values = new ArrayList<String>();
    map.put(user, values)
}
values.add(value);