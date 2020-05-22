public class JobService {

   @PersistenceContext
   EntityManager em;

   public void persistJob(Job newJob) {
     em.persist(newJob);
   }

   public Job getJob(Integer jobId) {
     return em.find(Job.class, jobId);
   }

   public void saveJob(Job job) {
      em.merge(job);
   }

   public void persistCategory(Category newcat) {
     em.persist(newcat);
   }

   public List<Category> getAllCategories() {
     return em.createQuery("from Category", Category.class).getResultList();
   }  
}