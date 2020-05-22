@Configuration
public class HibernateConfig {
   @Bean
   public SessionFactory sessionFactory(){
     return  new Configuration().configure("/resources/hibernate.cfg.xml")
                    .addAnnotatedClass(Tutor.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
   }
}