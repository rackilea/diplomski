Connection conn = DriverManager.getConnection(url,user,password);

User user = request.getSession().getAttribute(ATT_USER);
Product product = request.getSession().getAttribute(ATT_PRODUCT);

int userId = user.getId();
int productId = product.getId();

String query = "insert into transaction(user_id,product_id) values (?,?)";

PreparedStatement prep = conn.preparestatement(query);
        try {
            prep = conn.prepareStatement(query);

            prep.setInt(1,userId);
            prep.setInt(2,productId);

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }