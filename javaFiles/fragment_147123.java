StringBuilder resultText = new StringBuilder();

while (rs.next()) {
    resultText.append("Username: ").append(rs.getString(1)).append(" Score: ").append(rs.getString(2));
}
return resultText.toString();