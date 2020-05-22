public class Database {
    public static final String TBL_INCOME = "tbl_income";
    public static final String TBL_EXPENSES = "tbl_expenses";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://192.168.40.5/test", "root", "");
    }

    public List<Data> getData(String tbl_name) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "select * from " + tbl_name;

            try(ResultSet rs = connection.createStatement().executeQuery(query)) {
                List<Data> list = new ArrayList<>();
                while (rs.next()) {
                    Data data = new Data();
                    data.setDate(rs.getDate("date"));
                    data.setName(rs.getString("particular"));
                    data.setAmount(rs.getDouble("amount"));

                    list.add(data);
                }

                return list;
            }
        }
    }
}