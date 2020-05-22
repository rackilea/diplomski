private EmployeesRvAdapter adapter;

public void fireYourAsyncTask() {

    EmployeesService service = new RestService().getService();
    try {

        service.getEmployees(new Callback<List<Employee>>() {

            @Override
            public void success(List<Employee> employee, Response response) {
                employees.clear();
                employees.addAll(employee);
                adapter.notifyDatSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(emp.getContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });