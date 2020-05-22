@Repository
    public class myRepo {
        @PersistentContext
        private EntityManager em;

        public List findMyObjects(){
           String query = <some complicated SQL query>;
           return this.em.creatNativeQuery(query, "name of a SqlResultsetMapping").getResultList();
        }
    }