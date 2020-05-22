try (Connection con = getDatabaseConnection();) {
        try (Statement st = con.createStatement();) {
            try (ResultSet rs = st.executeQuery("SELECT * FROM TableName");) {
                ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
                while (rs.next()) {
                    ArrayList<String> row = new ArrayList<String>();
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        row.add(rs.getString(i + 1));
                    }
                    rows.add(row);
                }
                System.out.println(rows);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }