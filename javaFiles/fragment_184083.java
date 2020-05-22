public class DepartmentEditor extends PropertyEditorSupport {

    private DepartmentDao departmentDao;

    public DepartmentEditor(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Department department = departmentDao.find(id);
        setValue(department);
    }
}