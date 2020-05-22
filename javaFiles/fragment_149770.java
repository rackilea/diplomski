@Bean
   public MyBean getMyBean() {
     MyBean myBean = MyBean.getInstance();

     return myBean;
   }