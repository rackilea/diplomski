StringJoiner joiner = new StringJoiner("=? AND ", " WHERE ", "=?");
joiner.setEmptyValue("");

filters.keySet().forEach(joiner::add);

String query = "SELECT * FROM TABLE" + joiner.toString();