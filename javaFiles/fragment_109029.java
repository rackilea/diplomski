StringBuilder data = new StringBuilder();
while (rs.next()) {
    for (...) {
        data.append(rs.getString(i));
        data.append("|"); // Some separator
    }
    data.append("\n");
}

request.setAttribute("data", data);