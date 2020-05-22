@Service("otherBean")
    @Transactional
    public class OtherBeanClass implement IOtherBean {

     @Autowired
     IYourBean yourBean;

      @Transactional(propagation=Propagation.REQUIRED)
        public void test() {    
            yourBean.test1();
            yourBean.test2();       
        }

   }



    @Service("yourBean")
    @Transactional
    public class YourBeanClass implement IYourBean {



        @Transactional(propagation=Propagation.REQUIRED)
        public void test1() {
            this.jdbcTemplate.execute("INSERT INTO TEST VALUES('T', 'C2', 0, 1)");      
        }

        @Transactional(propagation=Propagation.NOT_SUPPORTED)
        public void test2() {
            System.out.println(this.jdbcTemplate.queryForInt("select count(*) from TEST"));         
        }
}