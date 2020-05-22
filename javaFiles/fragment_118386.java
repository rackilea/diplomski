response.setContentType("text/xml;charset=UTF-8");
PrintWriter writer = response.getWriter();
writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
writer.append("<sales_description>");

try (
    Connection connection = dataSource.getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT sale_id, home_id, agent_id, customer_id FROM sale");
) {
    if (resultSet.next()) {
        writer.append("<sale>");
        writer.append("<sale_id>").append(resultSet.getString("sale_id")).append("</sale_id>");
        writer.append("<home_id>").append(resultSet.getString("home_id")).append("</home_id>");
        writer.append("<agent_id>").append(resultSet.getString("agent_id")).append("</agent_id>");
        writer.append("</sale>");
    }
} catch (SQLException e) {
    throw new ServletException(e);
}

writer.append("</sales_description>");