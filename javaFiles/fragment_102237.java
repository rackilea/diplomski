private String createSqlStatement(int size) {
    StringBuilder sb = new StringBuilder();

    sb.append("SELECT s").append(size + 1).append(".stop_id  FROM stops s1 ").append("\n");
    for (int i = 1; i <= size; i++) {
        sb.append("  JOIN stops s").append(i + 1).append(" ON s").append(i).append(".stop_id = s").append(i + 1).append(".stop_id - 1")
                .append("\n");
    }
    sb.append(" WHERE CONCAT(");
    for (int i = 1; i <= size; i++) {
        sb.append("s").append(i).append(".name,");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append(") = CONCAT(");
    for (int i = 0; i <= size; i++) {
        sb.append("?,");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append(");");

    return sb.toString();

}