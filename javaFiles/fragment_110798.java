@Component 
public class DepartmentConverter implements Converter<String,Department>{
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public Department convert(String id){
        Department department = null;
        try {
            Integer id = Integer.parseInt(text);
            department = departmentDao.getById(id);
            System.out.println("Department name:" + department.getDepartmentName());
        } catch (NumberFormatException ex) {
            System.out.println("Department will be null");
        }
        return department;
    }
}