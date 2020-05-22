class EmployeeService extends Service<Integer>{

    @Override
    protected Task<Integer> createTask() {
        return new DisplayDataTask();
    }
}