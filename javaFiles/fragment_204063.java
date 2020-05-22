public List<String> completeArea(String inputName) {

        List<String> result = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String query1 = "select name from labels where name like ? order by name";
            try (Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost/company", "root", "");
                    PreparedStatement pst = con.prepareStatement(query1)) {

                pst.setString(1, inputName + "%");
                try (ResultSet rs = pst.executeQuery()) {}
                    while (rs.next()) {
                        result.add(rs.getString(1));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("error occured: " + ex);
        }
        return result;`
    }