@Service
public class StudentDAOImpl implements StudentDAO
{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StudentModel selectStudent (String npm)
    {
        StudentModel student = restTemplate.getForObject(url+npm, StudentModel.class);
        return student;
    }

    @Override
    public List<StudentModel> selectAllStudents ()
    {
       return null;
    }

}