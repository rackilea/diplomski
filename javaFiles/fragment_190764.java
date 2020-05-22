private class NewTaskListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String userName = view.getUsername();
        String newTask = view.getTaskName();

        model.AddNewTaskForUser(userName, newTask);
    }

}