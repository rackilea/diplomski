public class DepartmentBacking {

    private Long employeeId;
    private List<Department> list;

    private void load() {
        list = departmentService.list(employeeId);
    }

    public List<Department> getList() {
        if (list == null) load();
        return list;
    }

    // ...
}