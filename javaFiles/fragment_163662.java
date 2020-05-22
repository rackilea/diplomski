public class ToDoListModel {
    private DAO dao;

    public static ToDoListModel getInstance() {
        ToDoListModel model = new ToDoListModel();
        model.dao = new DAO();

        return model;
    }

    private ToDoListModel() {
    }

    public void addTask(Task task) throws SQLException {
        try(Connection connection = dao.getConnection()) {
            String q = "insert into todo (name) values (?)";

            try(PreparedStatement statement = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, task.getName());
                statement.executeUpdate();

                try(ResultSet rs = statement.getGeneratedKeys()) {
                    if(rs.next()) {
                        task.setId(rs.getInt(1));
                    }
                }
            }
        }
    }

    public void deleteTask(Task task) throws SQLException {
        try(Connection connection = dao.getConnection()) {
            String q = "delete from todo where id = ?";

            try(PreparedStatement statement = connection.prepareStatement(q)) {
                statement.setInt(1, task.getId());
                statement.executeUpdate();
            }
        }
    }

    public ObservableList<Task> getTaskList() throws SQLException {
        try(Connection connection = dao.getConnection()) {
            String q = "select * from todo";

            try(Statement statement = connection.createStatement()) {
                try(ResultSet rs = statement.executeQuery(q)) {
                    ObservableList<Task> tasks = FXCollections.observableArrayList();

                    while (rs.next()) {
                        Task task = new Task();
                        task.setId(rs.getInt("id"));
                        task.setName(rs.getString("name"));

                        tasks.add(task);
                    }

                    return tasks;
                }
            }
        }
    }
}