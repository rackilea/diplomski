class MySQLCategoryDAO extends SwingWorker<Void, Category> {

    // ...

    private List<Category> list; // do not modify inside doInBackground

    MySQLCategoryDAO(Job job, List<Category> list) {
        this.list = list;

        // ...
    }

    @Override
    protected Void doInBackground() {

        // ...

        while(results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");

            publish(new Category(id, name)); // publish results to the EDT
        }

        // ...

        return null;
    }

    @Override
    protected void process(List<Category> chunks) {
        list.addAll(chunks); // add results to the list on the EDT

        // add to the JTable (?)
    }
}

public void load() throws Exception {
    people.clear();
    DAOFactory factory = DAOFactory.getFactory(DAOFactory.MYSQL);
    CategoryDAO personDAO = factory.getCategoryDAO();

    // just execute
    new MySQLCategoryDAO(Job.SELECT, people).execute();
}