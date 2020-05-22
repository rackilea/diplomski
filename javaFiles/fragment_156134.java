public class TestPojo{
    public static void main(String[] args){
        Pojo p = new Pojo();
        p.setADate(new Date());
        p.setTheDate(new Date());

        PropertyUtils.getProperty(p, "theDate");
        PropertyUtils.getProperty(p, "aDate");
    }
}