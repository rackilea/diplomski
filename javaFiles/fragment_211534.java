public class ClassB {
    public ClassA classA;

    @Autowired
    public ClassB(ClassA classA){
     this.classA = classA;
     System.out.println(classA.str);
    }
}