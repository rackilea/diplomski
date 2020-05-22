public class CarDao implements Dao<Car>{

        private EntityManager em;

        public Car find(int id){
            return em.find(id, Car.class);
        }   

        public void insert(Car entity){
            em.persist(entity);
        } 

        public void update(Car entity){
            em.merge(entity);
        }

        public void delete(int id){
            em.delete(find(id));
        }

    }