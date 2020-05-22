@Component
public class GradeFormatter implements Formatter<Grade> {
    @Autowired
    private GradeService gradeService;
    @Override
    public String print(Grade grade, Locale locale) {
        return grade.getNumber() + grade.getAlfabetDigit();
    }
    @Override
    public Grade parse(String s, Locale locale) throws ParseException {
        return gradeService.getGrade( Integer.valueOf(s) );
    }
}