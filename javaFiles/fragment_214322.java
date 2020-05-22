public abstract class AnimalRepository<T extends IAnimal> {
     protected Class<T> clazz;

     public AnimalRepository(Class<T> clazz) {
         this.clazz = clazz;
     }

     public RealmResults<T> findAll(Realm realm) {
         return realm.where(clazz).findAll();
     }
}

 @Singleton
 public class GermanShepardRepository extends AnimalRepository<GermanShepard> {
      @Inject
      public GermanShepardRepository() {
          super(GermanShepard.class);
      }
 }