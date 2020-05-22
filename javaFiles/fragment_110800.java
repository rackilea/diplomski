public class SimpleDepartmentEditor extends PropertyEditorSupport {

    private DepartmentDao departmentDao;

    public SimpleDepartmentEditor(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Department department = null;
        try {
            Integer id = Integer.parseInt(text);
            department = departmentDao.getById(id);
            System.out.println("Department name:" + department.getDepartmentName());
        } catch (NumberFormatException ex) {
            System.out.println("Department will be null");
        }
        setValue(department);
    }
}