StringJoiner joiner = new StringJoiner(" AND ", " WHERE ", "");
joiner.setEmptyValue("");

filters.keySet().stream().map( key -> key + " = ?" ).forEach(joiner::add);

String query = "SELECT * FROM TABLE" + joiner.toString();