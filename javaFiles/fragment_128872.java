@Bean (name="dataSource", destroyMethod="")
    public DataSource getDatasourceConfiguration() {
        System.out.println("empezando a buscar jndi-------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {

        } 

     Hashtable<String, String> h = new Hashtable<String, String>();
     h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 

      InitialContext context=null;

     DataSource dataSource = null;
    try {
        context = new InitialContext(h);
        dataSource = (javax.sql.DataSource) context.lookup("ds_c719_002");      
        this.ds=dataSource;
        context.close();
        return dataSource;
    }catch(NamingException e){

        log.error(e);
        try { 
            dataSource = (javax.sql.DataSource) context.lookup("java:comp/env/ds_c719_002");
        } catch (NamingException e1) {
 System.out.println("--------ups----");
 e1.printStackTrace();
 System.exit(1);
        }


    }
      finally {
            try {
                context.close();}
         catch (Exception e) {
             e.printStackTrace();
         }
              // a failure occurred
            }
return null;
 }


    @Bean (name="sessionFactoryBean", destroyMethod="")
    public LocalSessionFactoryBean  sessionFactoryBean()
    {

        LocalSessionFactoryBean  asfb = new LocalSessionFactoryBean ();
        asfb.setHibernateProperties(getHibernateProperties());
         asfb.setDataSource(getDatasourceConfiguration());
         asfb.setPackagesToScan(new String[]{"mx.com.banamex.tdc.modelo"});
        return asfb;
    }

    @Bean 
        public SessionFactory sessionFactory() { 
            return sessionFactoryBean().getObject(); 
        }