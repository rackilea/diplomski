@Autowired
@Qualifier("st")
Student student;

...

StudentService ss = (StudentService) appContext.getBean("ss");
ss.setName("bravo");

System.out.println("NAME : " + student.getN());