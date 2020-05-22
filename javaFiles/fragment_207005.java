public class Employee {
    private int id;
    private String first;
    private String last;
    private int age;

    public Employee(int id, String first, String last, int age) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
    }

    /* getters and setters */
}

public class EmployeeQuery extends AbstractQuery<Employee> {

    public EmployeeQuery() {
    }

    protected String getTableName() {
        return "Employees";
    }

    protected String getSelectQuery() {
        return "id, first, last, age";
    }

    protected Employee parse(ResultSet rs) {
        int id  = rs.getInt("id");
        int age = rs.getInt("age");
        String first = rs.getString("first");
        String last = rs.getString("last");
        return new Employee(id, first, last, age);
    }

    protected String getUpdateColumns() {
        return "first = ?, last = ?, age = ?";
    }

    protected String getUpdateConstraint() {
        return "id = ?";
    }

    protected void bindValues(Employee record, PreparedStatement stmt) {
        stmt.bindString(1, record.getFirst());
        stmt.bindString(2, record.getLast());
        stmt.bindInt(3, record.getAge());
        stmt.bindInt(4, record.getID());
    }

}

public abstract class AbstractQuery<T> {
    protected abstract String getTableName();
    protected abstract String getSelectQuery();
    protected abstract T parse(ResultSet rs);
    protected abstract String getUpdateColumns();
    protected abstract String getUpdateConstraint();
    protected abstract void bindValues(T record, PreparedStatement stmt);

    public List<T> list() throws SQLException {
        List<T> results = new ArrayList<T>(25);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = // get connection
            stmt = con.createStatement();
            String query = "SELECT " + getSelectQuery() + " FROM " + getTableName();
            rs = stmt.executeQuery(query);
            while (rs.hasNext()) {
                results.add(parse(rs));
            }
        } finally {
            try {
                rs.close();
            } catch (Exception exp) {
            }
            try {
                stmt.close();
            } catch (Exception exp) {
            }
            // Close the connection if you need to...
        }
        return results;
    }

    public int update(T record) throws SQLException {
        int result = -1;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = // get connection
            String query = "UPDATE " + getTableName() + " SET " + getUpdateColumns() + " WHERE " + getUpdateConstraint();
            stmt = con.prepareStatement(query);

            bindValues(record, stmt);

            result = stmt.executeUpdate();
        } finally {
            try {
                rs.close();
            } catch (Exception exp) {
            }
            try {
                stmt.close();
            } catch (Exception exp) {
            }
            // Close the connection if you need to...
        }
        return result;
    }
}