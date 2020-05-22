public class Test {
    @Autowired
    ConfigProp configProp;

    public static void main(String args[]) {
        System.out.println(configProp.getUserName());//coming as null
    }
}