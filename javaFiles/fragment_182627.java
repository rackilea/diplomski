protected void createContents() {
    ...
    Statement statement = null; // local variable
    ...
     btnInsert.addMouseListener(new MouseAdapter() { // anonymous inner class
        @Override
        public void mouseDown(MouseEvent e) {
            ...
            try {
                statement.executeUpdate(query); // local variable out of scope here
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            ...
    });
}