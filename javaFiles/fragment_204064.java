public List<String> completeArea(String inputName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String query1 = "select name from labels where name like ? order by name";
            try (Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost/company", "root", "");
                    PreparedStatement pst = con.prepareStatement(query1)) {

                pst.setString(1, inputName + "%");
                try (ResultSet rs = pst.executeQuery()) {}

                    List<String> result = new ArrayList<>();
                    while (rs.next()) {
                        result.add(rs.getString(1));
                    }
                    return result;
                }
            }
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }