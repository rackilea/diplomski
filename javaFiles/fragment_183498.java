public class RetrieveValues {
    public static void main(String args[]) throws SQLException {
        Connection conn = null;
        Statement select = null;
        try {
            Class.forName("com.somejdbcvendor.TheirJdbcDriver");
            conn = DriverManager.getConnection(
                            "jdbc:somejdbcvendor:other data needed by some jdbc vendor",
                            "myLogin", "myPassword");
            select = conn.createStatement();
            ResultSet result = select
                    .executeQuery("SELECT Element FROM TestTable");

            List<Integer> elementList = new ArrayList<Integer>();
            while (result.next()) { // process results one row at a time
                elementList.add(result.getInt(1));
            }
            // convert to int array

            convertIntegers(elementList);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            select.close();
            conn.close();
        }
    }

    public static int[] convertIntegers(List<Integer> elemIntegers)
    {
        int[] elements = new int[elemIntegers.size()];
        for (int i=0; i < elements.length; i++)
        {
            elements[i] = elemIntegers.get(i).intValue();
        }
        return elements;
    }
}