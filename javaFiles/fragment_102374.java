//My first servlet using Java-8
 try (Connection con = DriverManager.getConnection("xxxx")) {
        String category = "fish";
        try (PrintWriter out = response.getWriter()) {
            try (ResultSet rs1 = con.createStatement()
                    .executeQuery("select * from product_list where category = '" + category + "'")) {
                HttpSession session = request.getSession();
                ArrayList<Float> list = new ArrayList<>();
                out.print(
                        "<table border=\"1\"><tr><th>Item_ID</th><th>Item_name</th><th>Title</th><th>Category</th><th>Image_name</th><th>Price</th><th>Stock_Count</th></tr>");
                while (rs1.next()) {
                    list.add(rs1.getFloat("item_id"));
                    out.println("<tr><td>" + rs1.getFloat("item_id") + "</td>");
                    out.println("<td>" + rs1.getString("item_name") + "</td>");
                    out.println("<td>" + "<a href ='" + request.getContextPath() + "/Second?id="+rs1.getFloat("item_id")+"'>"
                            + rs1.getString("title") + "</a>" + "</td>");
                    out.println("<td>" + rs1.getString("category") + "</td>");
                    out.println("<td>" + rs1.getString("image_name") + "</td>");
                    out.println("<td> " + rs1.getFloat("price") + "</td>");
                    out.println("<td> " + rs1.getFloat("stock_count") + "</td>");
                    out.println("</tr>");
                }
                session.setAttribute("list", list);
                out.println("</table>");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }